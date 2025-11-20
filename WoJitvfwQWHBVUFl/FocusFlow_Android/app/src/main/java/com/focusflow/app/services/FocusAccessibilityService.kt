package com.focusflow.app.services

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.accessibility.AccessibilityEvent
import android.widget.Toast
import com.focusflow.app.data.FocusFlowDatabase
import com.focusflow.app.data.FocusSessionRepository
import com.focusflow.app.ui.BlockScreenActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class FocusAccessibilityService : AccessibilityService() {

    private lateinit var repository: FocusSessionRepository
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onServiceConnected() {
        super.onServiceConnected()
        
        val database = FocusFlowDatabase.getDatabase(this)
        repository = FocusSessionRepository(database.focusSessionDao())

        val info = AccessibilityServiceInfo().apply {
            eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED or
                    AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED
            feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC
            notificationTimeout = 100
            flags = AccessibilityServiceInfo.FLAG_REPORT_VIEW_IDS
        }
        setServiceInfo(info)
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event == null) return

        when (event.eventType) {
            AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED -> {
                val packageName = event.packageName?.toString() ?: return
                checkIfAppShouldBeBlocked(packageName)
            }
        }
    }

    override fun onInterrupt() {
        // Pode ser deixado vazio
    }

    private fun checkIfAppShouldBeBlocked(packageName: String) {
        scope.launch {
            val activeSessions = repository.getActiveSessions()
            activeSessions.collect { sessions ->
                for (session in sessions) {
                    if (packageName in session.blockedApps) {
                        if (isCurrentlyInFocusPeriod(session)) {
                            blockApp(packageName, session.name)
                            return@collect
                        }
                    }
                }
            }
        }
    }

    private fun isCurrentlyInFocusPeriod(session: com.focusflow.app.data.FocusSession): Boolean {
        val calendar = Calendar.getInstance()
        val currentDay = calendar.get(Calendar.DAY_OF_WEEK) - 1 // 0 = Sunday

        if (currentDay !in session.days) return false

        for (period in session.timePeriods) {
            if (period.isCurrentlyActive()) {
                return true
            }
        }

        return false
    }

    private fun blockApp(packageName: String, sessionName: String) {
        val intent = Intent(this, BlockScreenActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            putExtra("packageName", packageName)
            putExtra("sessionName", sessionName)
        }
        startActivity(intent)

        // Voltar para a tela inicial
        performGlobalAction(GLOBAL_ACTION_HOME)
    }
}

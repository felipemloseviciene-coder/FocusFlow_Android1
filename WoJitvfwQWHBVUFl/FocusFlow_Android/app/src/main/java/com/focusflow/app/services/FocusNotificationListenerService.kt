package com.focusflow.app.services

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.focusflow.app.data.FocusFlowDatabase
import com.focusflow.app.data.FocusSessionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class FocusNotificationListenerService : NotificationListenerService() {

    private lateinit var repository: FocusSessionRepository
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        val database = FocusFlowDatabase.getDatabase(this)
        repository = FocusSessionRepository(database.focusSessionDao())
    }

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        if (sbn == null) return

        val packageName = sbn.packageName
        checkIfNotificationShouldBeSuppressed(packageName, sbn)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        // Pode ser deixado vazio
    }

    private fun checkIfNotificationShouldBeSuppressed(packageName: String, sbn: StatusBarNotification) {
        scope.launch {
            val activeSessions = repository.getActiveSessions()
            activeSessions.collect { sessions ->
                for (session in sessions) {
                    if (packageName in session.blockedApps) {
                        if (isCurrentlyInFocusPeriod(session)) {
                            cancelNotification(sbn.key)
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
}

package com.focusflow.app.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.focusflow.app.MainActivity
import com.focusflow.app.R
import com.focusflow.app.data.FocusFlowDatabase
import com.focusflow.app.data.FocusSessionRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FocusMonitorService : Service() {

    private lateinit var repository: FocusSessionRepository
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate() {
        super.onCreate()
        val database = FocusFlowDatabase.getDatabase(this)
        repository = FocusSessionRepository(database.focusSessionDao())
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startForeground(NOTIFICATION_ID, createNotification())
        
        scope.launch {
            repository.getActiveSessions().collect { sessions ->
                // Monitorar sessões ativas
                if (sessions.isNotEmpty()) {
                    updateNotification("FocusFlow está monitorando ${sessions.size} sessão(ões)")
                }
            }
        }

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                "FocusFlow Monitor",
                NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "Notificação de monitoramento do FocusFlow"
                setShowBadge(false)
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager?.createNotificationChannel(channel)
        }
    }

    private fun createNotification(): NotificationCompat.Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("FocusFlow")
            .setContentText("Monitorando suas sessões de foco")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentIntent(pendingIntent)
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(text: String) {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("FocusFlow")
            .setContentText(text)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setOngoing(true)
            .build()

        val manager = getSystemService(NotificationManager::class.java)
        manager?.notify(NOTIFICATION_ID, notification)
    }

    companion object {
        private const val NOTIFICATION_ID = 1
        private const val CHANNEL_ID = "focusflow_monitor"
    }
}

package com.focusflow.app.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.focusflow.app.services.FocusMonitorService

class BootReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            context?.let {
                val serviceIntent = Intent(it, FocusMonitorService::class.java)
                it.startService(serviceIntent)
            }
        }
    }
}

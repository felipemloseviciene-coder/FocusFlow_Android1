package com.focusflow.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "focus_sessions")
@TypeConverters(Converters::class)
data class FocusSession(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val days: List<Int>, // 0 = Sunday, 1 = Monday, etc.
    val timePeriods: List<TimePeriod>,
    val blockedApps: List<String>, // Package names
    val isActive: Boolean = true,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)

data class TimePeriod(
    val startHour: Int,
    val startMinute: Int,
    val endHour: Int,
    val endMinute: Int
) {
    fun toReadableString(): String {
        return String.format("%02d:%02d - %02d:%02d", startHour, startMinute, endHour, endMinute)
    }

    fun isCurrentlyActive(): Boolean {
        val now = java.util.Calendar.getInstance()
        val currentHour = now.get(java.util.Calendar.HOUR_OF_DAY)
        val currentMinute = now.get(java.util.Calendar.MINUTE)
        val currentTime = currentHour * 60 + currentMinute
        val startTime = startHour * 60 + startMinute
        val endTime = endHour * 60 + endMinute

        return currentTime in startTime until endTime
    }

    fun getMinutesUntilEnd(): Int {
        val now = java.util.Calendar.getInstance()
        val currentHour = now.get(java.util.Calendar.HOUR_OF_DAY)
        val currentMinute = now.get(java.util.Calendar.MINUTE)
        val currentTime = currentHour * 60 + currentMinute
        val endTime = endHour * 60 + endMinute

        return if (currentTime < endTime) {
            endTime - currentTime
        } else {
            0
        }
    }
}

data class BlockedApp(
    val packageName: String,
    val appName: String,
    val icon: String? = null
)

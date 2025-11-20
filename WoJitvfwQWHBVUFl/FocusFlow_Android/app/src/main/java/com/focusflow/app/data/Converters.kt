package com.focusflow.app.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromIntList(value: List<Int>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toIntList(value: String?): List<Int>? {
        return if (value == null) {
            null
        } else {
            val listType = object : TypeToken<List<Int>>() {}.type
            gson.fromJson(value, listType)
        }
    }

    @TypeConverter
    fun fromStringList(value: List<String>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toStringList(value: String?): List<String>? {
        return if (value == null) {
            null
        } else {
            val listType = object : TypeToken<List<String>>() {}.type
            gson.fromJson(value, listType)
        }
    }

    @TypeConverter
    fun fromTimePeriodList(value: List<TimePeriod>?): String? {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toTimePeriodList(value: String?): List<TimePeriod>? {
        return if (value == null) {
            null
        } else {
            val listType = object : TypeToken<List<TimePeriod>>() {}.type
            gson.fromJson(value, listType)
        }
    }
}

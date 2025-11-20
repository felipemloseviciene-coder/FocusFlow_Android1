package com.focusflow.app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FocusSessionDao {
    @Insert
    suspend fun insert(session: FocusSession): Long

    @Update
    suspend fun update(session: FocusSession)

    @Delete
    suspend fun delete(session: FocusSession)

    @Query("SELECT * FROM focus_sessions WHERE id = :id")
    suspend fun getById(id: Int): FocusSession?

    @Query("SELECT * FROM focus_sessions ORDER BY createdAt DESC")
    fun getAllSessions(): Flow<List<FocusSession>>

    @Query("SELECT * FROM focus_sessions WHERE isActive = 1 ORDER BY createdAt DESC")
    fun getActiveSessions(): Flow<List<FocusSession>>

    @Query("SELECT * FROM focus_sessions WHERE isActive = 0 ORDER BY createdAt DESC")
    fun getInactiveSessions(): Flow<List<FocusSession>>

    @Query("DELETE FROM focus_sessions")
    suspend fun deleteAll()
}

package com.focusflow.app.data

import kotlinx.coroutines.flow.Flow

class FocusSessionRepository(private val focusSessionDao: FocusSessionDao) {
    
    suspend fun insertSession(session: FocusSession): Long {
        return focusSessionDao.insert(session)
    }

    suspend fun updateSession(session: FocusSession) {
        focusSessionDao.update(session)
    }

    suspend fun deleteSession(session: FocusSession) {
        focusSessionDao.delete(session)
    }

    suspend fun getSessionById(id: Int): FocusSession? {
        return focusSessionDao.getById(id)
    }

    fun getAllSessions(): Flow<List<FocusSession>> {
        return focusSessionDao.getAllSessions()
    }

    fun getActiveSessions(): Flow<List<FocusSession>> {
        return focusSessionDao.getActiveSessions()
    }

    fun getInactiveSessions(): Flow<List<FocusSession>> {
        return focusSessionDao.getInactiveSessions()
    }

    suspend fun deleteAllSessions() {
        focusSessionDao.deleteAll()
    }

    fun getActiveSessionsForToday(): Flow<List<FocusSession>> {
        return focusSessionDao.getActiveSessions()
    }
}

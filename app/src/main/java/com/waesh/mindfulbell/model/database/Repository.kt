package com.waesh.mindfulbell.model.database

import com.waesh.mindfulbell.model.entity.Reminder
import kotlinx.coroutines.flow.Flow

class Repository(private val dao: RemindersDao) {

    val reminderList: Flow<List<Reminder>> = dao.getAll()
}
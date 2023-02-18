package com.waesh.mindfulbell.application

import android.app.Application
import com.waesh.mindfulbell.model.database.Database
import com.waesh.mindfulbell.model.database.Repository

class MindfulApplication: Application() {

    private val database: Database by lazy {
        Database.getDatabase(this@MindfulApplication)
    }
    val repository: Repository by lazy {
        Repository(database.getDao())
    }
}
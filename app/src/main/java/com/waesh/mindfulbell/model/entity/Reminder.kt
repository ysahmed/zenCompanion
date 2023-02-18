package com.waesh.mindfulbell.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(
    var body: String,
    @ColumnInfo(name = "enabled") var enabled: Boolean = false,
    @ColumnInfo(name = "favorite") var favorite: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

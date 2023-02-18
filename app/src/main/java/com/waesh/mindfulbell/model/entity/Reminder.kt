package com.waesh.mindfulbell.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reminders")
data class Reminder(
    var body: String,
    @ColumnInfo(name = "enabled") var enabled: Int = 0,
    @ColumnInfo(name = "favorite") var favorite: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

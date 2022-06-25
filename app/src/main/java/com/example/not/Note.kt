package com.example.not

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// entity in room is same as table in sqlite
// first step
@Entity(tableName = "notes_table")
data class Note(
    @ColumnInfo(name = "text")
    val text:String,
    @PrimaryKey(autoGenerate = true)
    var id :Int =0
)
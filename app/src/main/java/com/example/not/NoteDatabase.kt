package com.example.not

import android.content.Context
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Room
import androidx.room.RoomDatabase

//Third step
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun getNoteDao():NoteDao

    companion object {
        private var instance: NoteDatabase? = null
        private var LOCK=Any()
        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also {
                instance=it
            }
        }
        private fun buildDatabase(context: Context) =Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "NoteDatabase"
        ).build()
    }
}
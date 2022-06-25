package com.example.not

import androidx.lifecycle.LiveData
import androidx.room.*
//Data acces object
//Second step
@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Note)
    @Delete
    suspend fun delete(note:Note)
    @Query("SELECT * FROM NOTES_TABLE ORDER BY id ASC")
    fun getAllNote():LiveData<List<Note>>
//live data is used to observe the changes
}
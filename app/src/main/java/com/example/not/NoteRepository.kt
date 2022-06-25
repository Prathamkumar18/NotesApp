package com.example.not

import androidx.lifecycle.LiveData
//fourth step

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
    val allNotes: LiveData<List<Note>> = noteDao.getAllNote()

}
package com.example.not

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.chrono.HijrahChronology.INSTANCE
//fifth step
class NoteViewModel(application: Application) :AndroidViewModel(application) {
        var repository=NoteRepository(NoteDatabase.invoke(application).getNoteDao())
    var allNotes: LiveData<List<Note>> = repository.allNotes
    fun deleteNote(note:Note) =viewModelScope.launch(Dispatchers.IO){
            repository.delete(note)
    }
    fun insertNote(note: Note) =viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }
}
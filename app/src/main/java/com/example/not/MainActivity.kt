package com.example.not

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), INotesRVAdapter {
    lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var rv=findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager=LinearLayoutManager(this)
        val adapter=NotesRVAdapter(this,this)
        rv.adapter=adapter
        viewModel= ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModel::class.java)
        viewModel.allNotes.observe(this, Observer {list ->
            list?.let {
                adapter.update(it)
            }
        })


    }
    override fun onItemClicked(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_SHORT).show()
    }

    fun onClickSubmit(view: View) {
        var input=findViewById<EditText>(R.id.input)
        var noteinput=input.text.toString()
        if(noteinput.isNotEmpty()){
            viewModel.insertNote(Note(noteinput))
            Toast.makeText(this,"Note Inserted",Toast.LENGTH_SHORT).show()
        }
    }
}
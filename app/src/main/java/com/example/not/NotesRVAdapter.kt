package com.example.not

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(val context: Context,val listner:INotesRVAdapter): RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {
    val allNote= ArrayList<Note>()

    inner class NoteViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var textView=itemView.findViewById<TextView>(R.id.text)
        var deletebtn=itemView.findViewById<ImageView>(R.id.deletebtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder=NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deletebtn.setOnClickListener {
            listner.onItemClicked(allNote[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val current=allNote[position]
        holder.textView.text=current.text
    }

    override fun getItemCount(): Int {
        return allNote.size
    }
    fun update(newList:List<Note>){
        allNote.clear()
        allNote.addAll(newList)
        notifyDataSetChanged()
    }
}
interface INotesRVAdapter{
    fun onItemClicked(note:Note)
}
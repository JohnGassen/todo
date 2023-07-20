package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskItemAdapter(val listItems: List<String>,val longClickListener: OnLongClickListener): RecyclerView.Adapter<TaskItemAdapter.ViewHolder>() {
    interface OnLongClickListener{
        fun onItemLongClicked(position: Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = Inflater.inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: TaskItemAdapter.ViewHolder, position: Int) {
        val item = listItems.get(position)
        holder.textView.text = item
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView
        init{
            textView = itemView.findViewById(android.R.id.text1)
            itemView.setOnLongClickListener{
                longClickListener.onItemLongClicked(adapterPosition)
                true
            }
        }
        //val textView = itemView.findViewById<TextView>(R.id.addTask)
    }

}
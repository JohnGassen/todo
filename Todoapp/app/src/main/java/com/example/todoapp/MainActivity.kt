package com.example.todoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    val listTasks = mutableListOf<String>()
     lateinit var adapter: TaskItemAdapter
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        object : TaskItemAdapter.OnLongClickListener{
            override fun onItemLongClicked(position: Int) {
                listTasks.removeAt(position)
                adapter.notifyDataSetChanged()

            }
        }


        // check when the user click on add button
        //findViewById<Button>(R.id.button).setOnClickListener{

       // }
        listTasks.add("Faire du shopping")
        listTasks.add("Aller au marche")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
         adapter = TaskItemAdapter(listTasks)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.button).setOnClickListener{
            val userInputTask = findViewById<EditText>(R.id.addTask).text.toString()
            listTasks.add(userInputTask)
            adapter.notifyItemInserted( listTasks.size-1)
            findViewById<EditText>(R.id.addTask).setText("")

        }
    }
}
package com.example.ui_elements_p2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class QueueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queue)

        val songsToBeDisplayedList = intent.getStringArrayListExtra("songs")
        val songsToBeDisplayedArray = songsToBeDisplayedList!!.toTypedArray()
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, songsToBeDisplayedArray)
        val queuedSongsListView = findViewById<ListView>(R.id.queueListView)
        queuedSongsListView.adapter = adapter
    }
}
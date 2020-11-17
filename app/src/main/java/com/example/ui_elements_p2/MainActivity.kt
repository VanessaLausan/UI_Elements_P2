package com.example.ui_elements_p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    val queueListView = ArrayList<String>() //Array where all the songs queued will be stored and will be passed to the Queue activity
    val songsArray = arrayOf(
        "At My Worst", "Sofia", "Pastlives", "Mad at Disney", "Electric Love",  "Lemon Tree",//Chill Songs
        "Hooked", "Believer", "Bad Liar", "Roxanne", "Teeth", "Circles",//Rock
        "River", "Unworthy of Your Love", "Vienna", "Runaway",//the politician
        "Grow as we go", "Better",  "Butter cup",  "Turn Back Time", "Leaving on A Jet Plane", "Temporary Love",//Acoustics
        "End Game", "Delicate", "Dress", "Gateway Car", "I Did Something Bad", "Call It What You Want", "Gorgeous",//Reputation
    "Not Afraid Anymore",  "Nightmare", "Bad at Love", "Alone", "Without Me", "Finally", "Graveyard") //Badland by Halsey

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //list view adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, songsArray)
        val songsListView = findViewById<ListView>(R.id.songsListView)
        songsListView.adapter = adapter

        val listView = findViewById<ListView>(R.id.songsListView)
        registerForContextMenu(listView)
    }
    //Context Menu
    override fun onCreateContextMenu(
            menu: ContextMenu?,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.add_to_queue, menu)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {
        val menuInfo = item.menuInfo as AdapterView.AdapterContextMenuInfo //Allows us to inherit from the class Adapterview.AdapterCOntextMenuInfo to get the position
        return when (item.itemId) {
            R.id.add_song_to_queue -> {
                queueListView.add(songsArray[menuInfo.position])
                true
            }
            else -> {
                return super.onContextItemSelected(item)
            }

        }

    }
    //main menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.go_to_albums -> {
                startActivity(Intent(this, AlbumActivity::class.java))
                true
            }
            R.id.go_to_songs -> {
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            R.id.go_to_queue -> {
                val intent = Intent(this, QueueActivity::class.java)
                intent.putStringArrayListExtra("songs", queueListView)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
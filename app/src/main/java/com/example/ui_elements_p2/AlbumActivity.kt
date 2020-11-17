package com.example.ui_elements_p2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView

class AlbumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        //Map the Grid View
        val GridView = findViewById<GridView>(R.id.gridView) as GridView
        //Attach the adapter to the Grid View
        GridView.adapter = ImageAdapter(applicationContext)
        //Item click listener for the Grid View
        GridView.onItemClickListener = AdapterView.OnItemClickListener { parent, v, position, id ->
            val intent = Intent(this, AlbumDetailsActivity::class.java)
            var songsToBeDisplayed = arrayListOf<String>()
            var uri: String = ""
            if (position == 0) {
                uri = "@drawable/halsey"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.Halsey))
            } else if (position == 1) {
                uri = "@drawable/the_politician1"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.The_Politician))
            } else {
                uri = "@drawable/reputation"
                songsToBeDisplayed.clear()
                songsToBeDisplayed.addAll(resources.getStringArray(R.array.Reputation))
            }
            intent.putStringArrayListExtra("songs", songsToBeDisplayed)
            intent.putExtra("imageUri", uri)
            intent.putExtra("position", position)
            startActivity(intent)

        }
    }
}

package com.example.ui_elements_p2.models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlbumSong  (var id: Int = 0 , var albumSong: String, var albumTitle: String  )  {
    override fun toString(): String {
        return "$albumSong"
    }
}
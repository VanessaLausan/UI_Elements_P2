package com.example.ui_elements_p2.models

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Song (var id: Int = 0 , var title: String , var artist : String , var album : String) {
    override fun toString(): String {
        return "TITLE: $title \r ARTIST: $artist \r ALBUM: $album"
    }
}

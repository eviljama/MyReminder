package com.example.myreminder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MapActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
    }

    /** Called when the user taps the FAB button */
    fun fabPressed(view: View) {

        val editText = findViewById<TextView>(R.id.textView)
        val message = editText.text.toString()
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}

package com.example.myreminder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.TextView
import android.widget.Toast

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)
    }

    /** Called when the user taps the FAB button */
    fun fabPressed(view: View) {

        val editText = findViewById<TextView>(R.id.textView2)
        val message = editText.text.toString()
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


}

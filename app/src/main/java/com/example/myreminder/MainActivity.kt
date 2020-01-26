package com.example.myreminder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // get reference to button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Time button */
    fun timePressed(view: View) {
        val editText = findViewById<TextView>(R.id.tvTitle)
        val message = editText.text.toString()
        val intent = Intent(this, TimeActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /** Called when the user taps the Time button */
    fun mapPressed(view: View) {
        val editText = findViewById<TextView>(R.id.tvTitle)
        val message = editText.text.toString()
        val intent = Intent(this, MapActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    /** Called when the user taps the FAB button */
    fun fabPressed(context: Context, view: View) {

        context.toast("Main Fab pressed")
    }

    fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

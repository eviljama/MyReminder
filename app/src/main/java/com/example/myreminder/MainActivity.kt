package com.example.myreminder

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private val newWordActivityRequestCode = 1
    private lateinit var listView : ListView
    private lateinit var wordViewModel: WordViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById<ListView>(R.id.reminder_list_view)
// 1

        val arrayList = ArrayList<String>()//Creating an empty arraylist
        arrayList.add("yksi")//Adding object in arraylist
        arrayList.add("kaksi")
        arrayList.add("kolme")
        arrayList.add("neljä")//Adding object in arraylist
        arrayList.add("viisi")
        arrayList.add("kuusi")
        arrayList.add("seis")//Adding object in arraylist
        arrayList.add("kasiu")
        arrayList.add("ysi")
        arrayList.add("kymppi")//Adding object in arraylist
        arrayList.add("yytoo")
        arrayList.add("kaatoo")
        arrayList.add("kootoo")//Adding object in arraylist
        arrayList.add("neetoo")
        arrayList.add("viitoo")


// 2
        val listItems = arrayOfNulls<String>(arrayList.size)
// 3
        for (i in 0 until arrayList.size) {
            val value = arrayList[i]
            listItems[i] = value
        }
// 4
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        wordViewModel = ViewModelProvider(this).get(WordViewModel::class.java)
        wordViewModel.allWords.observe(this, Observer { words ->
            // Update the cached copy of the words in the adapter.
            //words?.let { adapter.setWords(it) }
        })
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

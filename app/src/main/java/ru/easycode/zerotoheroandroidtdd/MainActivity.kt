package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

const val KEY = "KEY"
class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var buttonHide: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        buttonHide = findViewById(R.id.hideButton)

        buttonHide.setOnClickListener {
            textView.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, textView.visibility)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle, ) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.visibility = savedInstanceState.getInt(KEY)
    }
}
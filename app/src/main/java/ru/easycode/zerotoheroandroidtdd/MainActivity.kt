package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        button.setOnClickListener {
            val layout = textView.parent as ViewGroup
            layout.removeView(textView)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle, ) {
        super.onRestoreInstanceState(savedInstanceState)
        val layout = textView.parent as ViewGroup
        layout.removeView(textView)
    }
}
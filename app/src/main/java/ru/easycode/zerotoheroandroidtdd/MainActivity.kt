package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var actionButton: Button
    lateinit var progressBar: ProgressBar
    lateinit var titleTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        actionButton = findViewById(R.id.actionButton)
        progressBar = findViewById(R.id.progressBar)
        titleTextView = findViewById(R.id.titleTextView)

        actionButton.setOnClickListener {
            actionButton.isEnabled = false
            progressBar.visibility = View.VISIBLE
//            actionButton.postDelayed({
//                titleTextView.visibility = View.VISIBLE
//                actionButton.isEnabled = true
//                progressBar.visibility = View.GONE
//            }, 3500)

            Handler(Looper.getMainLooper()).postDelayed({
                titleTextView.visibility = View.VISIBLE
                actionButton.isEnabled = true
                progressBar.visibility = View.GONE
            }, 3500)
        }
    }
}
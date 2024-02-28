package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var titleTextView: TextView
    private lateinit var actionButton: Button

    private val mainViewModel = MainViewModel(
        LiveDataWrapper.Base(),
        Repository.Base()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        titleTextView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)

        actionButton.setOnClickListener {
            mainViewModel.load()
        }

        mainViewModel.liveData().observe(this) {uiState ->
            uiState.apply(progressBar, titleTextView, actionButton)
        }
    }
}
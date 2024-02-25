package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var countTextView: TextView
    lateinit var incrementButton: Button
    lateinit var decrementButton: Button
    val  count = Count.Base(2, 4, 0)
    lateinit var state: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        incrementButton.setOnClickListener {
            state = count.increment(countTextView.text.toString())
            state.updateState(incrementButton, decrementButton, countTextView)
        }

        decrementButton.setOnClickListener {
            state = count.decrement(countTextView.text.toString())
            state.updateState(incrementButton, decrementButton, countTextView)
        }

        if (savedInstanceState == null){
            state = count.initial(countTextView.text.toString())
            state.updateState(incrementButton, decrementButton, countTextView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        state.updateState(incrementButton, decrementButton, countTextView)
    }

    companion object{
        const val KEY = "key"
    }
}
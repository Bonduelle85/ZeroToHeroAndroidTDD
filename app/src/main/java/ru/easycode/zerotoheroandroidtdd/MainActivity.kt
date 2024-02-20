package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var state: State = State.Initial
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var rootLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)
        rootLayout = findViewById(R.id.rootLayout)

        button.setOnClickListener {
            state = State.Removed
            state.apply(rootLayout, textView, button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY, State::class.java) as State
        state.apply(rootLayout, textView, button)
    }

    companion object{
        const val KEY = "key"
    }
}

interface State: Serializable {
    fun apply (layout: LinearLayout, textView: TextView, button: Button)
    object Initial: State {
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) {}
    }

    object  Removed: State{
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) {
            layout.removeView(textView)
            button.isEnabled = false
        }
    }
}
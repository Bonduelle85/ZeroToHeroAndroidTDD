package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var count: Count

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton.setOnClickListener {
            count = Count.Base(2)
            val number = countTextView.text.toString()
            countTextView.text = count.increment(number = number)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, countTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        countTextView.text = savedInstanceState.getString(KEY)
    }

    companion object {
        const val KEY = "key"
    }
}

interface Count : Serializable {
    fun increment(number: String): String
    class Base(var step: Int) : Count {

        init {
//            require(step>0) {"step should be positive, but was $step"}
            if (step<=0) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String) = "${number.toInt() + step}"
    }
}

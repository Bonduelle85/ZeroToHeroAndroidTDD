package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mutableList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val userInputText = binding.inputEditText.text.toString()
            mutableList.add(userInputText)

            addViewToContentLayout(userInputText)

            binding.inputEditText.text?.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, ArrayList(mutableList))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY)?.toMutableList() ?: mutableListOf()
        mutableList.addAll(list)

        mutableList.forEach { userInputText ->
            addViewToContentLayout(userInputText)
        }
    }

    private fun addViewToContentLayout(userInputText: String) {
        val textView = TextView(this)
        textView.text = userInputText
        binding.contentLayout.addView(textView)
    }

    companion object {
        const val KEY = "key"
    }
}
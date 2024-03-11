package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textWatcher = object : SimpleTextWatcher() {
            override fun afterTextChanged(s: Editable?) {
                if (s.toString() == "min"){
                    binding.actionButton.isEnabled = true
                }
            }
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text
            binding.titleTextView.text = text

            binding.inputEditText.setText("")

            binding.actionButton.isEnabled = false
        }

        binding.inputEditText.addTextChangedListener(textWatcher)
    }

    abstract class SimpleTextWatcher : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) = Unit
        override fun afterTextChanged(s: Editable?) = Unit
    }
}
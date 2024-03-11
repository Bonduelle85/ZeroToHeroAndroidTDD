package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text
            binding.titleTextView.text = text

            binding.inputEditText.setText("")

            binding.actionButton.isEnabled = false
        }

        binding.inputEditText.addTextChangedListener { text ->
            if (text.toString() == "min"){
                binding.actionButton.isEnabled = true
            }
        }
    }
}
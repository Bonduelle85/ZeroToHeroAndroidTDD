package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel(
        LiveDataWrapper.LiveDataImpl(),
        Repository.RepositoryImpl()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            viewModel.load()
        }

        viewModel.liveData().observe(this) {uiState ->
            uiState.updateState(
                binding.progressBar,
                binding.actionButton,
                binding.titleTextView
            )
        }
    }
}
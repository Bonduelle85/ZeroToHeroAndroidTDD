package ru.easycode.zerotoheroandroidtdd

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    //LiveData
    val viewModel by viewModels<MainViewModelLiveData>()

    // StateFlow
//    val viewModel by viewModels<MainViewModelStateFlow>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.rootLayout)

        binding.incrementButton.setOnClickListener {
            viewModel.increment()
        }

        binding.colorButton.setOnClickListener {
            viewModel.randomColor()
        }

        // initial state from LiveData
        if (viewModel.liveData.value == null) {
            viewModel.initialState(
                State(
                    color = Color.rgb(0, 0, 0),
                    number = 0
                )
            )
        }

        // observe from LiveData
        viewModel.liveData.observe(this) {state->
            binding.inputEditText.text = state.number.toString()
            binding.inputEditText.setTextColor(state.color)
        }

        // collect from flow
//        lifecycleScope.launch {
//            viewModel.mainFlow.collect { state  ->
//                binding.inputEditText.text = state.number.toString()
//                binding.inputEditText.setTextColor(state.color)
//            }
//        }
    }
}
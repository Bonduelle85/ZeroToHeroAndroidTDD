package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myRecyclerViewAdapter = MyRecyclerViewAdapter()

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myRecyclerViewAdapter
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            viewModel.add(text)
            binding.inputEditText.setText("")
        }

        viewModel.liveData.observe(this) { list ->
            myRecyclerViewAdapter.submitList(list)
        }
    }
}
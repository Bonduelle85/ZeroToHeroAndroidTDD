package ru.easycode.zerotoheroandroidtdd.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel
    private lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = viewModel(MainViewModel::class.java)

        viewModel.liveData().observe(this) { screen: Screen ->
            screen.show(supportFragmentManager, binding.container.id)
        }

        viewModel.init(savedInstanceState == null)
    }
    override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T =
        (application as ProvideViewModel).viewModel(viewModelClass)
}
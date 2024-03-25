package ru.easycode.zerotoheroandroidtdd.core

import androidx.lifecycle.ViewModel

interface ViewModelFactory : ProvideViewModel, ClearViewModel {

    class Base(
        private val provideViewModel: ProvideViewModel
    ) : ViewModelFactory {

        private val map = mutableMapOf<Class<out ViewModel>, ViewModel>()
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> viewModel(viewModelClass: Class<T>): T {
            val viewModel = map[viewModelClass]
            return if (viewModel != null) {
                viewModel as T
            } else {
                provideViewModel.viewModel(viewModelClass).also {
                    map[viewModelClass] = it
                }
            }
        }

        override fun clear(viewModelClass: Class<out ViewModel>) {
            map.remove(viewModelClass)
        }
    }
}
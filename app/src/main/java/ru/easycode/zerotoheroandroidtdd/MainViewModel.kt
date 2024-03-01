package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch


class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository
) : ViewModel() {

    private val viewModelScope = CoroutineScope(
        SupervisorJob() + Dispatchers.Main.immediate
    )

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        viewModelScope.launch {
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.save(bundleWrapper)
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        val uiState = bundleWrapper.restore()
        liveDataWrapper.update(uiState)
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {

                return MainViewModel(
                    LiveDataWrapper.LiveDataWrapperImpl(),
                    Repository.RepositoryImpl(),
                ) as T
            }
        }

    }
}
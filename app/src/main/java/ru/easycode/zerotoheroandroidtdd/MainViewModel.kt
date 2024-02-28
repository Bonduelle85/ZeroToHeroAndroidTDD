package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    val liveDataWrapper: LiveDataWrapper,
    val repository: Repository
) {

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
}
package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun update(value: UiState)

    fun liveData(): LiveData<UiState>

    class LiveDataImpl(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper{

        override fun liveData(): LiveData<UiState> = liveData

        override fun update(value: UiState){
            liveData.value = value
        }
    }
}
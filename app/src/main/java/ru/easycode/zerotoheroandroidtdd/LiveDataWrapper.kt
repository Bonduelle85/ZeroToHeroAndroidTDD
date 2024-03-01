package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

        fun liveData(): LiveData<UiState>

        fun update(state: UiState)

        fun save(bundleWrapper: BundleWrapper.Save)


    class LiveDataWrapperImpl(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : LiveDataWrapper {

        override fun liveData(): LiveData<UiState> = liveData

        override fun update(state: UiState) {
            liveData.value = state
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
        }
    }
}
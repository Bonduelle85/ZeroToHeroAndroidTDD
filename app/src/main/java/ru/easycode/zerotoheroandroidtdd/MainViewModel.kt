package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {

    private val _liveData = MutableLiveData<List<CharSequence>>()
    val liveData: LiveData<List<CharSequence>> = _liveData


    fun add(text: String) {
        val list = _liveData.value?.toMutableList() ?: mutableListOf()
        list.add(text)
        _liveData.value = list
    }
}
package ru.easycode.zerotoheroandroidtdd

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainViewModelLiveData : ViewModel() {

    private val mutableLiveData = MutableLiveData<State>()
    val liveData: LiveData<State> = mutableLiveData

    fun initialState(state: State){
        mutableLiveData.value = state
    }

    fun increment(){
        val oldState = liveData.value
        mutableLiveData.value = oldState?.copy(
            number = oldState.number + 1
        )
    }

    fun randomColor() {
        val oldState = liveData.value
        mutableLiveData.value = oldState?.copy(
            color = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        )
    }
}
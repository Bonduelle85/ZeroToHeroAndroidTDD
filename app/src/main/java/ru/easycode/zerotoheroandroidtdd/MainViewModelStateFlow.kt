package ru.easycode.zerotoheroandroidtdd

import android.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.random.Random

class MainViewModelStateFlow : ViewModel() {

    val mainFlow: MutableStateFlow<State> =
        MutableStateFlow(State(color = Color.rgb(0, 0, 0), number = 0))

    fun increment() {
        val oldState = mainFlow.value
        mainFlow.value = oldState.copy(
            number = oldState.number + 1
        )
    }

    fun randomColor() {
        val oldState = mainFlow.value
        mainFlow.value = oldState.copy(
            color = Color.rgb(
                Random.nextInt(256),
                Random.nextInt(256),
                Random.nextInt(256)
            )
        )
    }
}
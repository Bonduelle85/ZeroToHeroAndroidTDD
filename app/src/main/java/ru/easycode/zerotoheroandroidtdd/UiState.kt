package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun updateState(incButton: Button, decButton: Button, textView: TextView)

    data class Base(val text: String): UiState {
        override fun updateState(incButton: Button, decButton: Button, textView: TextView) {
            textView.text = text
            incButton.isEnabled = true
            decButton.isEnabled = true
        }
    }

    data class Max(val text: String): UiState {
        override fun updateState(incButton: Button, decButton: Button, textView: TextView) {
            textView.text = text
            incButton.isEnabled = false
            decButton.isEnabled = true
        }
    }

    data class Min(val text: String): UiState {
        override fun updateState(incButton: Button, decButton: Button, textView: TextView) {
            textView.text = text
            decButton.isEnabled = false
            incButton.isEnabled = true
        }
    }
}
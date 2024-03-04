package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun update(progressBar: ProgressBar, button: Button, textView: TextView)

    object ShowProgress: UiState{
        override fun update(progressBar: ProgressBar, button: Button, textView: TextView) {
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            textView.visibility = View.GONE
        }

    }

    data class ShowData(private val text: String): UiState{
        override fun update(progressBar: ProgressBar, button: Button, textView: TextView) {
            progressBar.visibility = View.GONE
            button.isEnabled = true
            textView.visibility = View.VISIBLE
            textView.text = text
        }

    }
}
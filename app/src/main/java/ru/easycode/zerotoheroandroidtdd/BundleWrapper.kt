package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(state: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    interface Mutable: Save, Restore

    class BundleWrapperImpl(
        private val bundle: Bundle
    ) : Mutable {

        override fun save(state: UiState) {
            bundle.putSerializable(KEY, state)
        }

        override fun restore(): UiState {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getSerializable(KEY, UiState::class.java) as UiState
            } else {
                bundle.getSerializable(KEY) as UiState
            }
        }
    }

    companion object{
        const val KEY = "key"
    }
}
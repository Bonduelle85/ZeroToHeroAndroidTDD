package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    val viewModel = MainViewModel(LiveDataWrapper.LiveDataImpl(), Repository.RepositoryImpl())
}
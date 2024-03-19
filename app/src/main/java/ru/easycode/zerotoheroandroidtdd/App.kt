package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    lateinit var listLiveDataWrapper: ListLiveDataWrapper

    override fun onCreate() {
        super.onCreate()
        listLiveDataWrapper = ListLiveDataWrapper.Base()
    }
}
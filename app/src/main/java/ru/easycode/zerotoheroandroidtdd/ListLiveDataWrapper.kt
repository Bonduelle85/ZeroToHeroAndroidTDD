package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {

    fun liveData(): LiveData<List<CharSequence>>

    fun add(new: CharSequence)

    fun save(bundle: BundleWrapper.Save)

    fun update(list: List<CharSequence>)

    class Base(
        private val liveData: MutableLiveData<List<CharSequence>> =
            SingleLiveEvent()
    ) : ListLiveDataWrapper {

        override fun liveData(): LiveData<List<CharSequence>> = liveData

        override fun add(new: CharSequence) {
            val list = liveData.value?.toMutableList() ?: mutableListOf()
            list.add(new)
            update(list)
        }

        override fun save(bundle: BundleWrapper.Save) {
            val arrayList = liveData.value?.let { ArrayList(it) }
            if (arrayList != null) {
                bundle.save(arrayList)
            }
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = list
        }
    }
}
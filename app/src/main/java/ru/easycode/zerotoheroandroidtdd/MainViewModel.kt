package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras


class MainViewModel(
    private val listLiveDataWrapper: ListLiveDataWrapper
) : ViewModel() {

    fun liveData(): LiveData<List<CharSequence>> = listLiveDataWrapper.liveData()

    fun add(text: String) {
        val list = listLiveDataWrapper.liveData().value?.toMutableList() ?: mutableListOf()
        list.add(text)
        listLiveDataWrapper.update(list)
    }

    fun save(bundle: BundleWrapper.Save){
        val arrayList = listLiveDataWrapper.liveData().value ?: ArrayList()
        bundle.save(ArrayList(arrayList))
    }

    fun restore(bundle: BundleWrapper.Restore){
        val list = bundle.restore()
        listLiveDataWrapper.update(list)
    }

    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return MainViewModel(
                    (application as App).listLiveDataWrapper,
                ) as T
            }
        }
    }
}
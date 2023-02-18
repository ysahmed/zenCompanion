package com.waesh.mindfulbell.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import com.waesh.mindfulbell.model.repository.Repository

class RemindersViewModel(private val repository: Repository): ViewModel() {

    val reminders = repository.reminders.asLiveData()

    fun updateEnabledById(id: Int, enabled: Boolean) = repository.updateEnabledById(id, enabled)

    fun updateFavoriteById(id: Int, favorite: Boolean) = repository.updateFavoriteById(id, favorite)

}

class RemindersViewModelFactory(private val repository: Repository): ViewModelProvider.Factory{
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RemindersViewModel::class.java)){
            return RemindersViewModel(repository) as T
        }
        throw java.lang.IllegalArgumentException("Unknown VM class. RemindersViewModel expected.")
    }
}
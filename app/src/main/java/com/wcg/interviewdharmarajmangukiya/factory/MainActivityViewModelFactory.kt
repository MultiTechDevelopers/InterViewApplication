package com.wcg.interviewdharmarajmangukiya.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wcg.interviewdharmarajmangukiya.data.network.repositories.MainActivityRepository
import com.wcg.interviewdharmarajmangukiya.viewModels.MainActivityViewModel

class MainActivityViewModelFactory(
    private val repository: MainActivityRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}
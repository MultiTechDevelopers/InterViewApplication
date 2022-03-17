package com.wcg.interviewdharmarajmangukiya.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wcg.interviewdharmarajmangukiya.Coroutines
import com.wcg.interviewdharmarajmangukiya.data.network.repositories.MainActivityRepository
import com.wcg.interviewdharmarajmangukiya.data.network.responses.BreedResponse
import kotlinx.coroutines.Job

class MainActivityViewModel(
    private val repository: MainActivityRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _getBreedsResponse = MutableLiveData<BreedResponse?>()
    val getBreedsResponse: LiveData<BreedResponse?>
        get() = _getBreedsResponse

    fun getBreeds(pageCount: String, listLimit: String) {
        job = Coroutines.ioThenMain(
            { repository.getBreedsCall(pageCount, listLimit) },
            { _getBreedsResponse.value = it }
        )
    }
}
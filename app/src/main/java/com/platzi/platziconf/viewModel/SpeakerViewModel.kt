package com.platzi.platziconf.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker
import com.platzi.platziconf.network.Callback
import com.platzi.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    val listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakersFromFirebase()
    }
    fun getSpeakersFromFirebase(){
        firestoreService.getSpeakers(object: Callback<List<Speaker>> {
            override fun onSucces(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }
    fun processFinished(){
        isLoading.value = true
    }
}
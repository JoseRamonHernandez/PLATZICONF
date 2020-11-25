package com.platzi.platziconf.viewModel

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Conference
import com.platzi.conf.model.Speaker
import com.platzi.platziconf.network.Callback
import com.platzi.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel {
    val firestoreService = FirestoreService()
    val listSchedule: MutableLiveData<List<Speaker>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getSpeakerFromFirebase()
    }
    fun getSpeakerFromFirebase(){
        firestoreService.getSchedule(object: Callback<List<Speaker>> {
            override fun onSucces(result: List<Speaker>?) {
                listSchedule.postValue(result)
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
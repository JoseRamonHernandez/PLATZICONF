package com.platzi.platziconf.viewModel

import androidx.lifecycle.MutableLiveData
import com.platzi.conf.model.Conference

import com.platzi.platziconf.network.Callback
import com.platzi.platziconf.network.FirestoreService
import java.lang.Exception

class ScheduleViewModel{
    val firestoreService = FirestoreService()
    val listSchedule: MutableLiveData<List<Conference>> = MutableLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getScheduleFromFirebase()
    }
    fun getScheduleFromFirebase(){
        firestoreService.getSchedule(object: Callback<List<Conference>>{
            override fun onSucces(result: List<Conference>?) {
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

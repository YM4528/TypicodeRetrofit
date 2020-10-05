package com.ydnm4528.typicoderetrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ydnm4528.typicoderetrofit.api.ApiClient
import com.ydnm4528.typicoderetrofit.model.Hospital
import retrofit2.Call
import retrofit2.Response


class HospitalViewModel : ViewModel(){

    private var hospital: MutableLiveData<Hospital> = MutableLiveData()

    fun getHospital () = hospital

    fun loadHospital() {

        val apiClient = ApiClient()

        val apiCall = apiClient.getAllHospital()

        apiCall.enqueue(object : retrofit2.Callback<Hospital> {
            override fun onFailure(call: Call<Hospital>, t: Throwable) {

            }

            override fun onResponse(call: Call<Hospital>, response: Response<Hospital>) {
                hospital.value = response.body()
            }

        })

    }

}
package com.ydnm4528.typicoderetrofit.api

import com.ydnm4528.typicoderetrofit.model.Hospital
import com.ydnm4528.typicoderetrofit.model.HospitalsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface HospitalApiInterface {

    @GET("hospital")
    fun getAllHospital(): retrofit2.Call<Hospital>


    //Path = {id}  //hospital/3
    @GET("hospital/{id}")
    fun getDetails(
        @Path("id") id: String
    ): retrofit2.Call<HospitalsItem>


}
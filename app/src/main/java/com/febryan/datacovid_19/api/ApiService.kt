package com.febryan.datacovid_19.api

import com.febryan.datacovid_19.model.ResponseIndonesia
import com.febryan.datacovid_19.model.ResponseProvinsi
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("indonesia")
    fun getDataCovidIndonesia() : Call<ArrayList<ResponseIndonesia>>

    @GET("indonesia")
    fun getIndonesia(): Call<ArrayList<ResponseIndonesia>>

    @GET("indonesia/provinsi")
    fun getDataProvinsi() : Call<ArrayList<ResponseProvinsi>>

}
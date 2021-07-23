package com.febryan.datacovid_19.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

//    const val baseUrl = "https://api.kawalcorona.com/"
//
//    fun getRetrofit() : Retrofit {
//        return Retrofit.Builder()
//                        .baseUrl(baseUrl)
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//    }
//
//    fun getService() : ApiService{
//        return getRetrofit().create(ApiService::class.java)
//    }

    private const val BASE_URL= "https://api.kawalcorona.com/"

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        retrofit.create(ApiService::class.java)
    }


}
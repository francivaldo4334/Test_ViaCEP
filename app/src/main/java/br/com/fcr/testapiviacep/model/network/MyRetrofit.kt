package br.com.fcr.testapiviacep.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyRetrofit {
    private val BASE_URL = "https://viacep.com.br/ws/"
    private val retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun apiService():InterfaceAPI{
        return retrofit.create(InterfaceAPI::class.java)
    }
}
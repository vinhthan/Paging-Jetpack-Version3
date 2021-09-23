package com.example.pagingjetpackversion3.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private const val baseURL = "https://rickandmortyapi.com/api/"

        fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}
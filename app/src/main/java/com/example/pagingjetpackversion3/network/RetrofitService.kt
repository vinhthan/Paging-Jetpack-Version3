package com.example.pagingjetpackversion3.network

import com.example.pagingjetpackversion3.model.UserList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("character")
    suspend fun getDataFromAPI(@Query("page") page: Int): UserList

}
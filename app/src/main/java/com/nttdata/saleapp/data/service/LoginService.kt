package com.nttdata.saleapp.data.service

import com.nttdata.saleapp.data.service.response.LoginResponse
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("login")
    suspend fun autenticate(
        @Query("username")
        username: String,
        @Query("password")
        password: String
    ): Response<LoginResponse>
}
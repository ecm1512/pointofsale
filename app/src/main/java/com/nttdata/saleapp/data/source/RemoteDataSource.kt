package com.nttdata.saleapp.data.source

interface RemoteDataSource {
    suspend fun autenticate(username: String, password: String): Boolean
}
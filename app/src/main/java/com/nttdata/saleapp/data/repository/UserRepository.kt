package com.nttdata.saleapp.data.repository

import com.nttdata.saleapp.data.source.RemoteDataSource

class UserRepository(private val remoteDataSource: RemoteDataSource) {

    suspend fun autenticate(username: String, password: String): Boolean{
        return remoteDataSource.autenticate(username,password)
    }

}
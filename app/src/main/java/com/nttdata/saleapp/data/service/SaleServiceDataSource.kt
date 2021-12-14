package com.nttdata.saleapp.data.service

import android.content.SharedPreferences
import com.nttdata.saleapp.data.source.RemoteDataSource

class SaleServiceDataSource(private val prefs: SharedPreferences): RemoteDataSource {
    override suspend fun autenticate(username: String, password: String): Boolean {
        val response = LoginRetrofit.service.autenticate(username,password).body()!!
        with(prefs.edit()){
            putInt("idStore",response.idStore)
            putInt("idUser",response.idUser)
        }
        return response.status == "ok"
    }
}
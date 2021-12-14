package com.nttdata.saleapp.data.service.response

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("code") val code: Int,
    @SerializedName("status") val status: String,
    @SerializedName("idStore") val idStore: Int,
    @SerializedName("idUser") val idUser: Int
)

package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.UserRepository

class Autenticate(private val userRepository: UserRepository) {
    suspend fun invoke(username: String, password: String) : Boolean{
        return userRepository.autenticate(username,password)
    }
}
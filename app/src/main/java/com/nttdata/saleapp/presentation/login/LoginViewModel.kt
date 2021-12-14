package com.nttdata.saleapp.presentation.login

import android.util.Log
import androidx.lifecycle.*
import com.nttdata.saleapp.domain.usecases.Autenticate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher

class LoginViewModel(private val autenticate: Autenticate): ViewModel() {

    val isAutenticated = MutableLiveData<Boolean>()
    val isLoading = MutableLiveData<Boolean>()

    fun autenticate(username: String, password: String) {
        viewModelScope.launch {
            try{
                isLoading.value = true

                val response = withContext(Dispatchers.IO){
                    autenticate.invoke(username,password)
                }
                Log.e("Login","aqui $response")
                isAutenticated.value = response

                isLoading.value = false
            }catch (e: Exception){
                isAutenticated.value = false
                isLoading.value = false
            }
        }

    }
}

class LoginViewModelFactory(
    private val autenticate: Autenticate
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(autenticate) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
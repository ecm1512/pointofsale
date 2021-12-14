package com.nttdata.saleapp.presentation.home.pos

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.usecases.GetSale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class PosViewModel(private val getSale: GetSale, private val prefs: SharedPreferences) : ViewModel() {

    private val _dataSale = MutableLiveData<List<Sale>>()
    val data: LiveData<List<Sale>> get() = _dataSale

    fun getSales(){
        viewModelScope.launch {
            try{
                val response = withContext(Dispatchers.IO){
                    getSale.invoke(prefs.getInt("idUser",0))
                }
                _dataSale.value = response
            }catch (e: Exception){
                Log.e("Sale fragment","Error retrieving sales")
            }
        }
    }
}
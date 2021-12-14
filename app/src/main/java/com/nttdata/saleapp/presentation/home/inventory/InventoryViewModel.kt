package com.nttdata.saleapp.presentation.home.inventory

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.usecases.GetInventory
import kotlinx.coroutines.launch
import java.lang.Exception

class InventoryViewModel(private val getInventory: GetInventory, private val prefs: SharedPreferences) : ViewModel() {

    private val _dataInventory = MutableLiveData<List<Inventory>>()
    val data: LiveData<List<Inventory>> get() = _dataInventory

    fun getInventory(){
        viewModelScope.launch {
            try{
                val response = getInventory.invoke(prefs.getInt("idStore",0))
                _dataInventory.value = response
            }catch (e: Exception){
                Log.e("Inventory fragment","Error retrieving inventory")
            }
        }
    }
}
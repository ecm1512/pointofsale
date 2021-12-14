package com.nttdata.saleapp.presentation.home.pos.newsale

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.usecases.GetInventory
import com.nttdata.saleapp.domain.usecases.GetInventoryById
import com.nttdata.saleapp.domain.usecases.InsertSale
import kotlinx.coroutines.launch

class NewSaleViewModel(private val getInventoryById: GetInventoryById,private val prefs: SharedPreferences) : ViewModel() {

    private val _dataInventory = MutableLiveData<List<Inventory>>()
    val data: LiveData<List<Inventory>> get() = _dataInventory

    fun getInventoryById(idInventory: Int){
        viewModelScope.launch {
            try{
                var tempList: MutableList<Inventory> = _dataInventory.value as MutableList<Inventory>
                val response = getInventoryById.invoke(prefs.getInt("idStore",0),idInventory)
                tempList.addAll(response)
                _dataInventory.value = tempList
            }catch (e: Exception){
                Log.e("New Sale fragment","Error retrieving inventory by Id")
            }
        }
    }

}
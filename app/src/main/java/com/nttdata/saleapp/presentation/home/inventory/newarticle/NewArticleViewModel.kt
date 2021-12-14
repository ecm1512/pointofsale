package com.nttdata.saleapp.presentation.home.inventory.newarticle

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nttdata.saleapp.domain.usecases.InsertInventory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewArticleViewModel(private val insertInventory: InsertInventory, private val prefs: SharedPreferences) : ViewModel() {

    val isSaved = MutableLiveData<Long>()
    private val idStore = prefs.getInt("idStore",0)

    fun insertInventory(name: String,stock: Int,price: Double){
        viewModelScope.launch {
            try{
                isSaved.value = -1
                val response = withContext(Dispatchers.IO){
                    insertInventory.invoke(name,stock,price,idStore)
                }
                isSaved.value = response
            }catch (e: Exception){
                isSaved.value = -1
            }
        }
    }
}
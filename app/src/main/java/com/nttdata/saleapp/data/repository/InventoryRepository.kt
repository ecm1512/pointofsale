package com.nttdata.saleapp.data.repository

import com.nttdata.saleapp.data.source.LocalDataSource
import com.nttdata.saleapp.domain.model.Inventory

class InventoryRepository(private val localDataSource: LocalDataSource) {
    suspend fun insertInventory(inventory: Inventory): Long {
        return localDataSource.insertInventory(inventory)
    }

    suspend fun getInventory(idStore: Int): List<Inventory> {
        return localDataSource.getInventory(idStore)
    }

    suspend fun getInventoryById(idStore: Int,idInventory: Int): List<Inventory>{
        return localDataSource.getInventoryById(idStore,idInventory)
    }
}
package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.InventoryRepository
import com.nttdata.saleapp.domain.model.Inventory

class InsertInventory(private val inventoryRepository: InventoryRepository) {
    suspend fun invoke(name: String,stock: Int,price: Double,idStore: Int): Long{
        val inventory = Inventory(name,stock,price,idStore)
        return inventoryRepository.insertInventory(inventory)
    }
}
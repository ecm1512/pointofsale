package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.InventoryRepository
import com.nttdata.saleapp.domain.model.Inventory

class GetInventoryById(private val inventoryRepository: InventoryRepository) {
    suspend fun invoke(idStore: Int, idInventory: Int): List<Inventory>{
        return inventoryRepository.getInventoryById(idStore, idInventory)
    }
}
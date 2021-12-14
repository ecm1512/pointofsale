package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.InventoryRepository
import com.nttdata.saleapp.domain.model.Inventory


class GetInventory(private val inventoryRepository: InventoryRepository) {
    suspend fun invoke(idStore: Int): List<Inventory>{
        return inventoryRepository.getInventory(idStore)
    }
}
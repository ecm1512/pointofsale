package com.nttdata.saleapp.data.source

import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.model.SaleDetail

interface LocalDataSource {
    suspend fun insertSale(sale: Sale)
    suspend fun getSale(idUser: Int): List<Sale>
    suspend fun insertDetailSale(saleDetail: SaleDetail)
    suspend fun getDetailSale(idSale: Int): List<SaleDetail>
    suspend fun insertInventory(inventory: Inventory) : Long
    suspend fun getInventory(idStore: Int): List<Inventory>
    suspend fun getInventoryById(idStore: Int, idInventory: Int): List<Inventory>
}
package com.nttdata.saleapp.data.database

import com.nttdata.saleapp.data.source.LocalDataSource
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.model.SaleDetail

class SaleDatabaseDataSource(db: SaleDatabase): LocalDataSource {

    private val inventoryDao = db.inventoryDao()
    private val saleDao = db.saleDao()
    private val saleDetailDao = db.saleDetailDao()
    override suspend fun insertSale(sale: Sale) {
        saleDao.insertSale(sale)
    }

    override suspend fun getSale(idUser: Int): List<Sale> {
        return saleDao.getSale(idUser)
    }

    override suspend fun insertDetailSale(saleDetail: SaleDetail) {
        saleDetailDao.insertSaleDetail(saleDetail)
    }

    override suspend fun getDetailSale(idSale: Int): List<SaleDetail> {
        return saleDetailDao.getSaleDetail(idSale)
    }

    override suspend fun insertInventory(inventory: Inventory): Long {
        return inventoryDao.insertInventory(inventory)
    }

    override suspend fun getInventory(idStore: Int): List<Inventory> {
        return inventoryDao.getInventory(idStore)
    }

    override suspend fun getInventoryById(idStore: Int, idInventory: Int): List<Inventory> {
        return inventoryDao.getInventoryById(idStore,idInventory)
    }


}
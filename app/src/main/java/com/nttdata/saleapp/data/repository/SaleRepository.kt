package com.nttdata.saleapp.data.repository

import com.nttdata.saleapp.data.source.LocalDataSource
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.model.SaleDetail

class SaleRepository(private val localDataSource: LocalDataSource) {

    suspend fun getSale(idUser: Int): List<Sale> {
        return localDataSource.getSale(idUser)
    }

    suspend fun insertSale(sale: Sale) {
        return localDataSource.insertSale(sale)
    }
}
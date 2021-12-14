package com.nttdata.saleapp.data.repository

import com.nttdata.saleapp.data.source.LocalDataSource
import com.nttdata.saleapp.domain.model.SaleDetail

class SaleDetailRepository(private val localDataSource: LocalDataSource) {
    suspend fun insertDetailSale(saleDetail: SaleDetail) {
        return localDataSource.insertDetailSale(saleDetail)
    }

    suspend fun getDetailSale(idSale: Int): List<SaleDetail> {
        return localDataSource.getDetailSale(idSale)
    }
}
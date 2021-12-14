package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.SaleDetailRepository
import com.nttdata.saleapp.domain.model.SaleDetail

class InsertDetailSale(private val saleDetailRepository: SaleDetailRepository) {
    suspend fun invoke(saleId: Int,inventoryId : Int,cant: Int,total: Double){
        val detailSale = SaleDetail(saleId,inventoryId,cant,total)
        return saleDetailRepository.insertDetailSale(detailSale)
    }
}
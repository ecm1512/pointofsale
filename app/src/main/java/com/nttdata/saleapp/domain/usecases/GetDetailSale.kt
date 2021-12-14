package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.SaleDetailRepository
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.model.SaleDetail

class GetDetailSale(private val saleDetailRepository: SaleDetailRepository) {
    suspend fun invoke(idSale: Int): List<SaleDetail>{
        return saleDetailRepository.getDetailSale(idSale)
    }
}
package com.nttdata.saleapp.domain.usecases

import com.nttdata.saleapp.data.repository.SaleRepository
import com.nttdata.saleapp.domain.model.Sale

class GetSale(private val saleRepository: SaleRepository) {
    suspend fun invoke(idUser: Int): List<Sale>{
        return saleRepository.getSale(idUser)
    }
}
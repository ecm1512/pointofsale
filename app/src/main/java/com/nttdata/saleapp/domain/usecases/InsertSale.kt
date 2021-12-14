package com.nttdata.saleapp.domain.usecases

import androidx.room.PrimaryKey
import com.nttdata.saleapp.data.repository.SaleRepository
import com.nttdata.saleapp.domain.model.Sale
import java.util.*

class InsertSale(private val saleRepository: SaleRepository) {
    suspend fun invoke(date: Date,total: Double,client: String,idUser : Int){
        val sale = Sale(date, total,client,idUser)
        return saleRepository.insertSale(sale)
    }
}
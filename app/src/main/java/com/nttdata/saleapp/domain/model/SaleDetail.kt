package com.nttdata.saleapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SaleDetail(
    val idSale: Int,
    val inventoryId : Int,
    val cant: Int,
    val total: Double,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
package com.nttdata.saleapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Inventory (
    val name: String,
    val stock: Int,
    val price: Double,
    val idStore: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
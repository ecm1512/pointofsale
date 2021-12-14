package com.nttdata.saleapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.nttdata.saleapp.data.database.utils.Converter
import java.util.*

@Entity
data class Sale(
    val date: Date,
    val total: Double,
    val client: String,
    val idUser : Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
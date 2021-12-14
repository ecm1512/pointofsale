package com.nttdata.saleapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nttdata.saleapp.domain.model.Sale


@Dao
interface SaleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSale(sale: Sale)

    @Query("SELECT * FROM Sale WHERE idUser = :idUser")
    fun getSale(idUser: Int): List<Sale>
}
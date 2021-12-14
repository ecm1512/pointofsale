package com.nttdata.saleapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nttdata.saleapp.domain.model.SaleDetail

@Dao
interface SaleDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSaleDetail(saleDetail: SaleDetail)

    @Query("SELECT * FROM SaleDetail WHERE idSale = :idSale")
    fun getSaleDetail(idSale: Int): List<SaleDetail>
}
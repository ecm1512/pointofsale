package com.nttdata.saleapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nttdata.saleapp.domain.model.Inventory

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertInventory(inventory: Inventory): Long

    @Query("SELECT * FROM Inventory WHERE idStore = :idStore")
    fun getInventory(idStore: Int): List<Inventory>

    @Query("SELECT * FROM Inventory WHERE idStore = :idStore and id = :idInventory ")
    fun getInventoryById(idStore: Int, idInventory: Int): List<Inventory>
}
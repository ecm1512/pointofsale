package com.nttdata.saleapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nttdata.saleapp.data.database.utils.Converter
import com.nttdata.saleapp.domain.model.Inventory
import com.nttdata.saleapp.domain.model.Sale
import com.nttdata.saleapp.domain.model.SaleDetail

@Database(entities = [Inventory::class, Sale::class, SaleDetail::class], version = 1)
@TypeConverters( Converter::class)
abstract class SaleDatabase: RoomDatabase() {
    companion object{
        fun build(context: Context) = Room.databaseBuilder(
            context,
            SaleDatabase::class.java,
            "SaleDb"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    abstract fun saleDao() : SaleDao

    abstract fun inventoryDao(): InventoryDao

    abstract fun saleDetailDao(): SaleDetailDao
}
package com.nttdata.saleapp.data.database.utils

import androidx.room.TypeConverter
import java.util.*

class Converter {
    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate(date: Date?): Long?{
        return date?.time?.toLong()
    }
}
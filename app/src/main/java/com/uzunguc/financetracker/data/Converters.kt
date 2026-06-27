package com.uzunguc.financetracker.data

import androidx.room.TypeConverter
import java.math.BigDecimal
import java.time.LocalDateTime

class Converters {
    @TypeConverter
    fun fromBigDecimal(value: BigDecimal):String{
        return value.toString()
    }
    @TypeConverter
    fun toBigDecimal(value: String): BigDecimal{
        return value.toBigDecimal()
    }
    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime): String{
        return value.toString()
    }
    @TypeConverter
    fun toLocalDateTime(value: String): LocalDateTime{
        return LocalDateTime.parse(value)
    }
}
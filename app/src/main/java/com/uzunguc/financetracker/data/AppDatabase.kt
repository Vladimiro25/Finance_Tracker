package com.uzunguc.financetracker.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uzunguc.financetracker.data.entity.CategoryEntity
import com.uzunguc.financetracker.data.entity.OperationEntity


@Database(entities = [CategoryEntity::class, OperationEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
}
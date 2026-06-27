package com.uzunguc.financetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.uzunguc.financetracker.data.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM CategoryEntity")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Insert
    suspend fun addCategory(categoryEntity: CategoryEntity): Long

    @Delete
    suspend fun deleteCategory(id: CategoryEntity)

    @Update
    suspend fun updateCategory(id: CategoryEntity)
}
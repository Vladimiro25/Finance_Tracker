package com.uzunguc.financetracker.domain.repository

import com.uzunguc.financetracker.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun addCategory(categoryEntity: Category): Long
    suspend fun deleteCategory(id: Category)
    suspend fun updateCategory(id: Category)
}
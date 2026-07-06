package com.uzunguc.financetracker.domain.repository

import com.uzunguc.financetracker.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    fun getAllCategories(): Flow<List<Category>>
    suspend fun addCategory(category: Category): Long
    suspend fun deleteCategory(category: Category)
    suspend fun updateCategory(category: Category)
}
package com.uzunguc.financetracker.data.repository

import com.uzunguc.financetracker.data.dao.CategoryDao
import com.uzunguc.financetracker.data.mapper.toDomain
import com.uzunguc.financetracker.data.mapper.toEntity
import com.uzunguc.financetracker.domain.model.Category
import com.uzunguc.financetracker.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl(private val categoryDao: CategoryDao) : CategoryRepository {
    override fun getAllCategories(): Flow<List<Category>> {
        return categoryDao.getAllCategories().map { categoryList ->
            categoryList.map { categoryEntity ->
                categoryEntity.toDomain()
            }
        }
    }

    override suspend fun addCategory(categoryEntity: Category): Long {
        return categoryDao.addCategory(categoryEntity.toEntity())
    }

    override suspend fun deleteCategory(id: Category) {
        return categoryDao.deleteCategory(id.toEntity())
    }

    override suspend fun updateCategory(id: Category) {
        return categoryDao.updateCategory(id.toEntity())
    }

}
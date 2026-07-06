package com.uzunguc.financetracker.domain.usecase.category

import com.uzunguc.financetracker.domain.model.Category
import com.uzunguc.financetracker.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetAllCategoriesUseCase(private val repository: CategoryRepository) {
    operator fun invoke(): Flow<List<Category>> = repository.getAllCategories()
}
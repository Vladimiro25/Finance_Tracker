package com.uzunguc.financetracker.domain.usecase.category

import com.uzunguc.financetracker.domain.model.Category
import com.uzunguc.financetracker.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCategoriesUseCase @Inject constructor(private val repository: CategoryRepository) {
    operator fun invoke(): Flow<List<Category>> = repository.getAllCategories()
}
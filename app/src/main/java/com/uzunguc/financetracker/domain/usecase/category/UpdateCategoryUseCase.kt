package com.uzunguc.financetracker.domain.usecase.category

import com.uzunguc.financetracker.domain.model.Category
import com.uzunguc.financetracker.domain.repository.CategoryRepository

class UpdateCategoryUseCase(private val repository: CategoryRepository) {

    suspend operator fun invoke(category: Category) = repository.updateCategory(category)
}
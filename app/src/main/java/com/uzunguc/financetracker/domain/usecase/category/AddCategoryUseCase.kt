package com.uzunguc.financetracker.domain.usecase.category

import com.uzunguc.financetracker.domain.model.Category
import com.uzunguc.financetracker.domain.repository.CategoryRepository
import javax.inject.Inject

class AddCategoryUseCase @Inject constructor(private val repository: CategoryRepository) {
    suspend operator fun invoke(category: Category): Long = repository.addCategory(category)
}
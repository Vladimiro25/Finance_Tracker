package com.uzunguc.financetracker.domain.usecase.operation

import com.uzunguc.financetracker.domain.repository.OperationRepository

class GetTotalExpenseUseCase(private val repository: OperationRepository) {
    suspend operator fun invoke() : Double? = repository.getTotalExpense()
}
package com.uzunguc.financetracker.domain.usecase.operation

import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.repository.OperationRepository

class UpdateTransactionUseCase(private val repository: OperationRepository) {
    suspend operator fun invoke(operation: Operation) = repository.updateTransaction(operation)
}
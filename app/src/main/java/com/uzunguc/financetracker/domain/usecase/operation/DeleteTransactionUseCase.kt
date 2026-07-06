package com.uzunguc.financetracker.domain.usecase.operation

import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.repository.OperationRepository

class DeleteTransactionUseCase(private val repository: OperationRepository) {
    suspend operator fun invoke(operation: Operation) = repository.deleteTransaction(operation)
}
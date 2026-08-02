package com.uzunguc.financetracker.domain.usecase.operation

import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.repository.OperationRepository
import javax.inject.Inject

class DeleteTransactionUseCase @Inject constructor(private val repository: OperationRepository) {
    suspend operator fun invoke(operation: Operation) = repository.deleteTransaction(operation)
}
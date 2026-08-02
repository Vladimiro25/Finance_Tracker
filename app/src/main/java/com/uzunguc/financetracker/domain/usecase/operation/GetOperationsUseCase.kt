package com.uzunguc.financetracker.domain.usecase.operation

import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.repository.OperationRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOperationsUseCase @Inject constructor(private val repository: OperationRepository) {
    operator fun invoke(): Flow<List<Operation>> = repository.getOperations()
}
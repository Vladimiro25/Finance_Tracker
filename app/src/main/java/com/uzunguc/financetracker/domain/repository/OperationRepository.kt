package com.uzunguc.financetracker.domain.repository

import com.uzunguc.financetracker.domain.model.Operation
import kotlinx.coroutines.flow.Flow

interface OperationRepository {

    fun getOperations(): Flow<List<Operation>>
    suspend fun addTransaction(operation: Operation): Long
    suspend fun deleteTransaction(operation: Operation)
    suspend fun updateTransaction(operation: Operation)
}
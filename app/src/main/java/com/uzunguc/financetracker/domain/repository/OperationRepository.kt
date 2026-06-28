package com.uzunguc.financetracker.domain.repository

import com.uzunguc.financetracker.ui.Operation
import kotlinx.coroutines.flow.Flow

interface OperationRepository {

    fun getOperations(): Flow<List<Operation>>
    suspend fun getTotalBalance(): Double?
    suspend fun getTotalExpense(): Double?
    suspend fun addTransaction(transaction: Operation): Long
    suspend fun deleteTransaction(id: Operation)
    suspend fun updateTransaction(id: Operation)
}
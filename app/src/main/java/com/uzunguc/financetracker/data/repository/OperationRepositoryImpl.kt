package com.uzunguc.financetracker.data.repository

import com.uzunguc.financetracker.data.dao.OperationDao
import com.uzunguc.financetracker.data.mapper.toDomain
import com.uzunguc.financetracker.data.mapper.toEntity
import com.uzunguc.financetracker.domain.repository.OperationRepository
import com.uzunguc.financetracker.ui.Operation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class OperationRepositoryImpl(private val operationDao: OperationDao) : OperationRepository {
    override fun getOperations(): Flow<List<Operation>> {
        return operationDao.getOperations().map {entityList ->
            entityList.map { entity -> entity.toDomain() }
        }
    }

    override suspend fun getTotalBalance(): Double? {
        return operationDao.getTotalBalance()
    }

    override suspend fun getTotalExpense(): Double? {
        return operationDao.getTotalExpense()
    }

    override suspend fun addTransaction(transaction: Operation): Long {
        return operationDao.addTransaction(transaction.toEntity())
    }

    override suspend fun deleteTransaction(id: Operation) {
        return operationDao.deleteTransaction(id.toEntity())
    }

    override suspend fun updateTransaction(id: Operation) {
        return operationDao.updateTransaction(id.toEntity())
    }
}
package com.uzunguc.financetracker.data.repository

import com.uzunguc.financetracker.data.dao.OperationDao
import com.uzunguc.financetracker.data.mapper.toDomain
import com.uzunguc.financetracker.data.mapper.toEntity
import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.repository.OperationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OperationRepositoryImpl @Inject constructor(private val operationDao: OperationDao) : OperationRepository {
    override fun getOperations(): Flow<List<Operation>> {
        return operationDao.getOperations().map {entityList ->
            entityList.map { entity -> entity.toDomain() }
        }
    }

    override suspend fun addTransaction(operation: Operation): Long {
        return operationDao.addTransaction(operation.toEntity())
    }

    override suspend fun deleteTransaction(operation: Operation) {
        return operationDao.deleteTransaction(operation.toEntity())
    }

    override suspend fun updateTransaction(operation: Operation) {
        return operationDao.updateTransaction(operation.toEntity())
    }

    override fun getTransactionById(id: Int): Flow<Operation?> {
        return operationDao.getTransactionById(id).map { entity ->
            entity?.toDomain()
        }
    }
}

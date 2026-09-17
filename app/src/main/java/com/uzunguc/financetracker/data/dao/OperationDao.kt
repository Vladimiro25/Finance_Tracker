package com.uzunguc.financetracker.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.uzunguc.financetracker.data.entity.OperationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OperationDao {

    @Query("SELECT * FROM OperationEntity")
    fun getOperations(): Flow<List<OperationEntity>>

    @Query("SELECT * FROM OperationEntity WHERE date BETWEEN :startDate AND :endDate")
    fun getOperationsFromDate(
        startDate: String,
        endDate: String
    ): Flow<List<OperationEntity>>

    @Insert
    suspend fun addTransaction(operation: OperationEntity): Long

    @Delete
    suspend fun deleteTransaction(operation: OperationEntity)

    @Update
    suspend fun updateTransaction(operation: OperationEntity)

    @Query("SELECT * FROM OperationEntity WHERE id = :id")
    fun getTransactionById(id: Int): Flow<OperationEntity?>

}
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

    @Query(" SELECT\n" +
            "      SUM(CASE WHEN type = 'INCOME' THEN CAST(sum AS REAL) ELSE 0 END) -\n" +
            "      SUM(CASE WHEN type = 'EXPENSE' THEN CAST(sum AS REAL) ELSE 0 END)\n" +
            "  FROM OperationEntity ")
    suspend fun getTotalBalance(): Double?

    @Query(" SELECT SUM(CAST(sum AS REAL)) FROM OperationEntity WHERE type = 'EXPENSE' ")
    suspend fun getTotalExpense(): Double?

    @Query("SELECT * FROM OperationEntity WHERE date BETWEEN :startDate AND :endDate")
    fun getTotalExpenseFromDate(
        startDate: String,
        endDate: String
    ): Flow<List<OperationEntity>>

    @Insert
    suspend fun addTransaction(transaction: OperationEntity): Long

    @Delete
    suspend fun deleteTransaction(id: OperationEntity)

    @Update
    suspend fun updateTransaction(id: OperationEntity)

}
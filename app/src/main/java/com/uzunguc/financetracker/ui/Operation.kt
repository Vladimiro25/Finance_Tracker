package com.uzunguc.financetracker.ui

import java.math.BigDecimal
import java.time.LocalDateTime

data class Operation(
    val id: Int,
    val name: String,
    val sum: BigDecimal,
    val type: TypeOperation,
    val date: LocalDateTime
)

enum class TypeOperation(val title: String) {
    INCOME("Income"),
    EXPENSE("Expense")
}

package com.uzunguc.financetracker.feature.home.ui

import java.time.LocalDateTime

data class Operation(
    val id: Int,
    val name: String,
    val sum: Long,
    val type: TypeOperation,
    val date: LocalDateTime
)

enum class TypeOperation(val title: String) {
    INCOME("Income"),
    EXPENSE("Expense")
}

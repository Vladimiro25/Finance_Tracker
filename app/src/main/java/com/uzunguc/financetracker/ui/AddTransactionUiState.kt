package com.uzunguc.financetracker.ui

import com.uzunguc.financetracker.TypeOperation

data class AddTransactionUiState(
    val name: String = "",
    val type: TypeOperation = TypeOperation.EXPENSE,
    // TODO: category selection not implemented yet — categoryId stays null until Add
    //  Transaction UI supports it
    val categoryId: Int? = null,
    val amount: String = "",
    val amountError: String? = null,
    val nameError: String? = null,
    val error: String? = null,
)

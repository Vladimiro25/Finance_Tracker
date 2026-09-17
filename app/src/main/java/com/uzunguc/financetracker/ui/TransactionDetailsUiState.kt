package com.uzunguc.financetracker.ui

import com.uzunguc.financetracker.domain.model.Operation

data class TransactionDetailsUiState(
    val isLoading: Boolean = true,
    val operation: Operation? = null,
    val error: String? = null,
)

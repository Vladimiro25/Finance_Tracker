package com.uzunguc.financetracker.ui

import java.math.BigDecimal

data class HomeUiState(
    val isLoading: Boolean = true,
    val operations: List<Operation> = emptyList(),
    val income: BigDecimal = BigDecimal.ZERO,
    val outcome: BigDecimal = BigDecimal.ZERO,
    val overallBalance: BigDecimal = BigDecimal.ZERO,
    val error: String? = null
)
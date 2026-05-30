package com.uzunguc.financetracker.ui

sealed class HomeUiState {
    data object Loading: HomeUiState()
    data class Error(val error: String): HomeUiState()
    data class Success(val operation: List<Operation>, val income: Long, val outcome: Long, val overallBalance:Long): HomeUiState()
}
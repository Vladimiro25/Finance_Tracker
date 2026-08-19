package com.uzunguc.financetracker.ui

sealed class HomeEffect {
    data class NavigateToTransactionDetails(val operationId: Int) : HomeEffect()
}
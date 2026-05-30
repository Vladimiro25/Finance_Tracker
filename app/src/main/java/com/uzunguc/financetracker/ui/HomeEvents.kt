package com.uzunguc.financetracker.ui

sealed class HomeUiEvent {
    object LoadHomeData : HomeUiEvent()
    data class NavigateToTransactionDetails(val transactionId: Int) : HomeUiEvent()
    data class SelectDateFilter(val filter: DateFilter) : HomeUiEvent()
    object AddTransactionClick : HomeUiEvent()
}
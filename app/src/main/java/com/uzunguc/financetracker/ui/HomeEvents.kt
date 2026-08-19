package com.uzunguc.financetracker.ui

import com.uzunguc.financetracker.DateFilter

sealed class HomeUiEvent {
    object LoadHomeData : HomeUiEvent()
    data class SelectDateFilter(val filter: DateFilter) : HomeUiEvent()
    object AddTransactionClick : HomeUiEvent()
    object ErrorShown : HomeUiEvent()
    data class TransactionClick(val operationId: Int) : HomeUiEvent()
}
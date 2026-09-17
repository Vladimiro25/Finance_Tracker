package com.uzunguc.financetracker.ui

sealed class TransactionDetailsUiEvent {
    object BackClicked : TransactionDetailsUiEvent()
    object DeleteClicked : TransactionDetailsUiEvent()
    object ErrorShown : TransactionDetailsUiEvent()
}

package com.uzunguc.financetracker.ui

import com.uzunguc.financetracker.TypeOperation

sealed class AddTransactionUiEvent {
    data class AmountChanged(val amount: String) : AddTransactionUiEvent()
    data class NameChanged(val name: String) : AddTransactionUiEvent()
    data class TypeChanged(val type: TypeOperation) : AddTransactionUiEvent()
    object SaveTransaction : AddTransactionUiEvent()
    object ErrorShown : AddTransactionUiEvent()
    object BackClicked : AddTransactionUiEvent()
}
package com.uzunguc.financetracker.ui

sealed class AddTransactionEffect {
    object NavigateBack : AddTransactionEffect()
}

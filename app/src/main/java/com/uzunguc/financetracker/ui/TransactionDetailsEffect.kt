package com.uzunguc.financetracker.ui

sealed class TransactionDetailsEffect {
    object NavigateBack : TransactionDetailsEffect()
}

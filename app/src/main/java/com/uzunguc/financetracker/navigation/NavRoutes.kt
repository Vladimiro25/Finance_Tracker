package com.uzunguc.financetracker.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeRoute

@Serializable
data class TransactionDetailsRoute(val transactionId: Int)
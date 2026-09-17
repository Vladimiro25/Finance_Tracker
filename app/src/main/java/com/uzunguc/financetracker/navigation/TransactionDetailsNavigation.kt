package com.uzunguc.financetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uzunguc.financetracker.FinanceTrackerApp
import com.uzunguc.financetracker.ui.TransactionDetailsEffect
import com.uzunguc.financetracker.ui.TransactionDetailsScreen
import com.uzunguc.financetracker.ui.TransactionDetailsViewModel


@Composable
fun TransactionDetailsNavigation(navController: NavController, operationId: Int) {
    val context = LocalContext.current
    val factory = remember {
        val assistedFactory = (context.applicationContext as FinanceTrackerApp)
            .appComponent.transactionDetailsViewModelFactory()
        object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(operationId) as T
            }
        }
    }
    val viewModel: TransactionDetailsViewModel = viewModel(factory = factory)
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                TransactionDetailsEffect.NavigateBack -> {
                    navController.popBackStack()
                }
            }
        }
    }
    TransactionDetailsScreen(state = state, onEvent = viewModel::sendEvent)
}

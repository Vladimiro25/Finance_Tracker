package com.uzunguc.financetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uzunguc.financetracker.FinanceTrackerApp
import com.uzunguc.financetracker.ui.HomeEffect
import com.uzunguc.financetracker.ui.HomeScreen
import com.uzunguc.financetracker.ui.HomeViewModel


@Composable
fun HomeNavigation(navController: NavController) {
    val context = LocalContext.current
    val factory =
        remember { (context.applicationContext as FinanceTrackerApp).appComponent.daggerViewModelFactory() }
    val viewModel: HomeViewModel = viewModel(factory = factory)
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                is HomeEffect.NavigateToTransactionDetails -> {
                    navController.navigate(TransactionDetailsRoute(effect.operationId))
                }
            }
        }
    }
    HomeScreen(state = state, onEvent = viewModel::sendEvent)
}
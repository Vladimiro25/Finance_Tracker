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
import com.uzunguc.financetracker.ui.AddTransactionEffect
import com.uzunguc.financetracker.ui.AddTransactionScreen
import com.uzunguc.financetracker.ui.AddTransactionViewModel


@Composable
fun AddTransactionNavigation(navController: NavController) {
    val context = LocalContext.current
    val factory =
        remember { (context.applicationContext as FinanceTrackerApp).appComponent.daggerViewModelFactory() }
    val viewModel: AddTransactionViewModel = viewModel(factory = factory)
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.effect.collect { effect ->
            when (effect) {
                AddTransactionEffect.NavigateBack -> {
                    navController.popBackStack()
                }
            }
        }
    }
    AddTransactionScreen(state = state, onEvent = viewModel::sendEvent)
}

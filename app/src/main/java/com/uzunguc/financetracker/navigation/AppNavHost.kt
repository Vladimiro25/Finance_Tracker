package com.uzunguc.financetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = HomeRoute,
        modifier = modifier
    ) {
        composable<HomeRoute> {
            HomeNavigation(navController)
        }
        composable<TransactionDetailsRoute> { backStackEntry ->
            val route = backStackEntry.toRoute<TransactionDetailsRoute>()
            TransactionDetailsNavigation(navController, route.operationId)
        }
        composable<AddTransactionRoute> {
            AddTransactionNavigation(navController)
        }
    }
}

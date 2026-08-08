package com.uzunguc.financetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.uzunguc.financetracker.ui.HomeScreen
import com.uzunguc.financetracker.ui.HomeViewModel
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val factory = remember{(application as FinanceTrackerApp).appComponent.daggerViewModelFactory()}
            val viewModel: HomeViewModel = viewModel(factory = factory)
            val state by viewModel.state.collectAsState()

            FinanceTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(
                        state = state,
                        onEvent = viewModel::sendEvent,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

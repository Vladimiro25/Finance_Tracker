package com.uzunguc.financetracker.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.DateFilter
import com.uzunguc.financetracker.ui.compose.DateFilterTabs
import com.uzunguc.financetracker.ui.compose.GraphicsBalanceExpense
import com.uzunguc.financetracker.ui.compose.SavingsGoalCard
import com.uzunguc.financetracker.ui.compose.TransactionItem
import com.uzunguc.financetracker.ui.compose.WelcomeBar
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeScreen(
    state: HomeUiState,
    onEvent: (HomeUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LaunchedEffect(state.error) {
        if (state.error != null) {
            Toast.makeText(context, "Something went wrong. Please try again.", Toast.LENGTH_SHORT).show()
            onEvent(HomeUiEvent.ErrorShown)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Spacer(Modifier.height(16.dp))

        WelcomeBar(modifier = Modifier.padding(horizontal = 16.dp))

        Spacer(Modifier.height(24.dp))

        GraphicsBalanceExpense(
            balance = formatAmount(state.overallBalance),
            expense = "-${formatAmount(state.outcome)}",
            // TODO: budget-limit isn't modeled in HomeUiState yet — hardcoded until that's designed
            progress = 0.3f,
            targetText = "$20,000.00",
            text = "30% of your expenses, looks good."
        )

        Spacer(Modifier.height(16.dp))

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            if (state.isLoading) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            } else {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp)
                ) {
                    item {
                        // TODO: no real savings-goal / weekly revenue-food data modeled yet — hardcoded until that's designed
                        SavingsGoalCard(
                            savingsProgress = 0.6f,
                            revenueLastWeek = "$4,000.00",
                            foodLastWeek = "-$100.00"
                        )
                        Spacer(Modifier.height(24.dp))
                    }

                    item {
                        DateFilterTabs(
                            selectedFilter = DateFilter.MONTHLY,
                            onFilterSelected = { onEvent(HomeUiEvent.SelectDateFilter(it)) }
                        )
                        Spacer(Modifier.height(16.dp))
                    }

                    if (state.operations.isEmpty()) {
                        item {
                            Text(
                                text = "No transactions yet",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    } else {
                        items(state.operations, key = { it.id }) { operation ->
                            TransactionItem(
                                operation = operation,
                                amountText = formatAmount(operation.sum)
                            )
                            Spacer(Modifier.height(16.dp))
                        }
                    }
                }
            }
        }
    }
}

private fun formatAmount(amount: BigDecimal): String =
    NumberFormat.getCurrencyInstance(Locale.US).format(amount)

@PreviewLightDark
@Composable
private fun HomeScreenPreview() {
    FinanceTrackerTheme {
        HomeScreen(state = HomeUiState(isLoading = false), onEvent = {})
    }
}

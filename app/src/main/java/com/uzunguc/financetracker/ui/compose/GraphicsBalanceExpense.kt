package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.R
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

@Composable
fun GraphicsBalanceExpense(
    modifier: Modifier = Modifier,
    balance: String,
    expense: String,
    progress: Float,
    targetText: String,
    text: String
) {

    Column(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TotalBalance(balance = balance, color = MaterialTheme.colorScheme.onPrimary)
            TotalExpense(balance = expense, color = MaterialTheme.colorScheme.error)
        }

        Spacer(Modifier.height(12.dp))

        BudgetProgressBar(progress = progress, targetText = targetText)

        Spacer(Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_check),
                contentDescription = null
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = text
            )
        }
    }

}

@PreviewLightDark
@Composable
fun GraphicsBalanceExpensePreview() {
    FinanceTrackerTheme {
        GraphicsBalanceExpense(
            balance = "$1,234.56",
            expense = "$456.78",
            progress = 0.3f,
            targetText = "$20,000.00",
            text = "30% of your expenses, looks good."
        )
    }
}
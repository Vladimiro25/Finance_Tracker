package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.R
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

@Composable
fun TotalBalance(
    balance: String,
    modifier: Modifier = Modifier,
    color: Color
) {
    Column(modifier = modifier) {
        Row(
            Modifier.size(width = 100.dp, height = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(R.drawable.ic_income),
                contentDescription = ""
            )
            Text(
                text = "Total Balance",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

        }

        Text(
            text = balance,
            style = MaterialTheme.typography.headlineLarge,
            color = color,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@PreviewLightDark
fun TotalBalancePreview() {
    FinanceTrackerTheme {
        TotalBalance(balance = "$1,234.56", color = MaterialTheme.colorScheme.primary)
    }
}

package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.R
import com.uzunguc.financetracker.TypeOperation
import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val dateFormatter = DateTimeFormatter.ofPattern("HH:mm - MMMM d")

@Composable
fun TransactionItem(
    operation: Operation,
    amountText: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(color = MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(
                        if (operation.type == TypeOperation.INCOME) R.drawable.ic_income else R.drawable.ic_expense
                    ),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Column(modifier = Modifier.padding(start = 12.dp)) {
                Text(text = operation.name, style = MaterialTheme.typography.bodyLarge)
                Text(
                    text = operation.date.format(dateFormatter),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Text(
            text = amountText,
            style = MaterialTheme.typography.bodyLarge,
            color = if (operation.type == TypeOperation.INCOME) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.error
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun TransactionItemPreview() {
    FinanceTrackerTheme {
        TransactionItem(
            operation = Operation(
                id = 1,
                name = "Salary",
                sum = BigDecimal("4000"),
                type = TypeOperation.INCOME,
                date = LocalDateTime.of(2026, 4, 30, 18, 27)
            ),
            amountText = "$4,000.00"
        )
    }
}

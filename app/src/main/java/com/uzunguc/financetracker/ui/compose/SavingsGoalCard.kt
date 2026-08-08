package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.R
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

@Composable
fun SavingsGoalCard(
    savingsProgress: Float,
    revenueLastWeek: String,
    foodLastWeek: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        color = MaterialTheme.colorScheme.primary
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SavingsGoal(progress = savingsProgress)

            VerticalDivider(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(64.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                WeeklyStatRow(
                    iconRes = R.drawable.ic_savings,
                    label = "Revenue Last Week",
                    value = revenueLastWeek
                )

                HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                WeeklyStatRow(
                    iconRes = R.drawable.ic_category_food,
                    label = "Food Last Week",
                    value = foodLastWeek
                )
            }
        }
    }
}

@Composable
private fun WeeklyStatRow(
    iconRes: Int,
    label: String,
    value: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )

        Spacer(Modifier.width(8.dp))

        Column {
            Text(text = label, style = MaterialTheme.typography.labelSmall)
            Text(
                text = value,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun SavingsGoalCardPreview() {
    FinanceTrackerTheme {
        SavingsGoalCard(
            savingsProgress = 0.6f,
            revenueLastWeek = "$4,000.00",
            foodLastWeek = "-$100.00"
        )
    }
}

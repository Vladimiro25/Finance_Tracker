package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.DateFilter
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

private val displayedFilters = listOf(DateFilter.DAILY, DateFilter.WEEKLY, DateFilter.MONTHLY)

@Composable
fun DateFilterTabs(
    selectedFilter: DateFilter,
    onFilterSelected: (DateFilter) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        displayedFilters.forEach { filter ->
            val isSelected = filter == selectedFilter
            Surface(
                shape = RoundedCornerShape(50),
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                onClick = { onFilterSelected(filter) }
            ) {
                Text(
                    text = filter.name.lowercase().replaceFirstChar { it.uppercase() },
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun DateFilterTabsPreview() {
    FinanceTrackerTheme {
        DateFilterTabs(selectedFilter = DateFilter.MONTHLY, onFilterSelected = {})
    }
}

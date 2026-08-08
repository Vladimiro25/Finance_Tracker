package com.uzunguc.financetracker.ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uzunguc.financetracker.R
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

@Composable
fun SavingsGoal(
    progress: Float,        // 0f..1f
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(72.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                progress = { progress },
                modifier = Modifier.fillMaxSize(),
                strokeWidth = 5.dp,
                strokeCap = StrokeCap.Butt,
                // onPrimary, not primary — this ring sits on a primary-colored card (SavingsGoalCard),
                // so using `primary` here would blend into the background and disappear
                color = MaterialTheme.colorScheme.onPrimary,
                trackColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f),
                gapSize = 0.dp
            )

            Icon(
                modifier = Modifier.size(48.dp),
                painter = painterResource(R.drawable.ic_car),
                contentDescription = null,
            )
        }

        Text(
            modifier = Modifier.width(60.dp),
            text = "Savings On Goals",
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }

}

@PreviewLightDark
@Composable
private fun SavingsGoalPreview() {
    FinanceTrackerTheme {
        Surface(color = MaterialTheme.colorScheme.primary) {
            SavingsGoal(modifier = Modifier.padding(16.dp), progress = 0.8f)
        }
    }
}
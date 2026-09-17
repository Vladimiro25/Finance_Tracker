package com.uzunguc.financetracker.ui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.uzunguc.financetracker.TypeOperation
import com.uzunguc.financetracker.ui.theme.FinanceTrackerTheme

@Composable
fun AddTransactionScreen(
    state: AddTransactionUiState,
    onEvent: (AddTransactionUiEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    LaunchedEffect(state.error) {
        if (state.error != null) {
            Toast.makeText(context, state.error, Toast.LENGTH_SHORT).show()
            onEvent(AddTransactionUiEvent.ErrorShown)
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Spacer(Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        ) {
            IconButton(
                onClick = { onEvent(AddTransactionUiEvent.BackClicked) },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

            Text(
                text = "Add Transaction",
                modifier = Modifier.align(Alignment.Center),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary
            )
        }

        Spacer(Modifier.height(24.dp))

        Surface(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp)
            ) {
                TypeOperationTabs(
                    selectedType = state.type,
                    onTypeSelected = { onEvent(AddTransactionUiEvent.TypeChanged(it)) }
                )

                Spacer(Modifier.height(24.dp))

                OutlinedTextField(
                    value = state.name,
                    onValueChange = { onEvent(AddTransactionUiEvent.NameChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Title") },
                    isError = state.nameError != null,
                    supportingText = {
                        state.nameError?.let { Text(it) }
                    },
                    singleLine = true
                )

                Spacer(Modifier.height(16.dp))

                OutlinedTextField(
                    value = state.amount,
                    onValueChange = { onEvent(AddTransactionUiEvent.AmountChanged(it)) },
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text("Amount") },
                    isError = state.amountError != null,
                    supportingText = {
                        state.amountError?.let { Text(it) }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    singleLine = true
                )

                Spacer(Modifier.height(32.dp))

                Button(
                    onClick = { onEvent(AddTransactionUiEvent.SaveTransaction) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 48.dp)
                ) {
                    Text("Save")
                }
            }
        }
    }
}

@Composable
private fun TypeOperationTabs(
    selectedType: TypeOperation,
    onTypeSelected: (TypeOperation) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        TypeOperation.entries.forEach { type ->
            val isSelected = type == selectedType
            Surface(
                shape = RoundedCornerShape(50),
                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                onClick = { onTypeSelected(type) }
            ) {
                Text(
                    text = type.title,
                    modifier = Modifier.padding(horizontal = 32.dp, vertical = 10.dp),
                    style = MaterialTheme.typography.labelLarge,
                    color = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun AddTransactionScreenPreview() {
    FinanceTrackerTheme {
        AddTransactionScreen(
            state = AddTransactionUiState(
                name = "Dinner",
                amount = "26.00",
                type = TypeOperation.EXPENSE
            ),
            onEvent = {}
        )
    }
}

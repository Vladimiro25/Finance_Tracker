package com.uzunguc.financetracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uzunguc.financetracker.delegate.DefaultMviDelegate
import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.usecase.operation.AddTransactionUseCase
import com.uzunguc.financetracker.mvi.MviController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

class AddTransactionViewModel @Inject constructor(
    private val addTransactionUseCase: AddTransactionUseCase,
) : ViewModel(), MviController<AddTransactionUiState, AddTransactionUiEvent> {

    private val delegate = DefaultMviDelegate(AddTransactionUiState())
    override val state = delegate.state

    private val _effect = Channel<AddTransactionEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    override fun sendEvent(event: AddTransactionUiEvent) {
        when (event) {
            is AddTransactionUiEvent.NameChanged -> {
                delegate.updateState { it.copy(name = event.name, nameError = null) }
            }

            is AddTransactionUiEvent.AmountChanged -> {
                delegate.updateState { it.copy(amount = event.amount, amountError = null) }
            }

            is AddTransactionUiEvent.TypeChanged -> {
                delegate.updateState { it.copy(type = event.type) }
            }

            AddTransactionUiEvent.ErrorShown -> {
                delegate.updateState { it.copy(error = null) }
            }

            AddTransactionUiEvent.SaveTransaction -> {
                save()
            }

            AddTransactionUiEvent.BackClicked -> {
                viewModelScope.launch { _effect.send(AddTransactionEffect.NavigateBack) }
            }
        }
    }

    private fun save() {
        val current = state.value
        val sum = current.amount.toBigDecimalOrNull()
        val nameError = if (current.name.isBlank()) "Name is required" else null
        val amountError = if (sum == null) "Enter a valid amount" else null

        if (sum == null || nameError != null) {
            delegate.updateState { it.copy(nameError = nameError, amountError = amountError) }
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            try {
                addTransactionUseCase(
                    Operation(
                        id = 0,
                        name = current.name.trim(),
                        sum = sum,
                        type = current.type,
                        date = LocalDateTime.now(),
                        categoryId = current.categoryId,
                    )
                )
                _effect.send(AddTransactionEffect.NavigateBack)
            } catch (e: Exception) {
                delegate.updateState { it.copy(error = e.message ?: "Failed to save transaction") }
            }
        }
    }
}

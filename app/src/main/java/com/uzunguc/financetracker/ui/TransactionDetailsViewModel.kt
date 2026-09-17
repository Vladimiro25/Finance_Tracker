package com.uzunguc.financetracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uzunguc.financetracker.delegate.DefaultMviDelegate
import com.uzunguc.financetracker.domain.usecase.operation.DeleteTransactionUseCase
import com.uzunguc.financetracker.domain.usecase.operation.GetOperationByIdUseCase
import com.uzunguc.financetracker.mvi.MviController
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class TransactionDetailsViewModel @AssistedInject constructor(
    @Assisted private val operationId: Int,
    private val getOperationByIdUseCase: GetOperationByIdUseCase,
    private val deleteTransactionUseCase: DeleteTransactionUseCase,
) : ViewModel(), MviController<TransactionDetailsUiState, TransactionDetailsUiEvent> {

    @AssistedFactory
    interface Factory {
        fun create(operationId: Int): TransactionDetailsViewModel
    }

    private val delegate = DefaultMviDelegate(TransactionDetailsUiState())
    override val state = delegate.state

    private val _effect = Channel<TransactionDetailsEffect>(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    override fun sendEvent(event: TransactionDetailsUiEvent) {
        when (event) {
            TransactionDetailsUiEvent.BackClicked -> {
                viewModelScope.launch { _effect.send(TransactionDetailsEffect.NavigateBack) }
            }

            TransactionDetailsUiEvent.DeleteClicked -> {
                delete()
            }

            TransactionDetailsUiEvent.ErrorShown -> {
                delegate.updateState { it.copy(error = null) }
            }
        }
    }

    private fun observeOperation() {
        viewModelScope.launch(Dispatchers.IO) {
            getOperationByIdUseCase(operationId)
                .catch { throwable ->
                    delegate.updateState { it.copy(isLoading = false, error = throwable.message) }
                }
                .collect { operation ->
                    if (operation == null) {
                        // Deleted (or never existed) — nothing to show, close the screen.
                        _effect.send(TransactionDetailsEffect.NavigateBack)
                    } else {
                        delegate.updateState {
                            it.copy(isLoading = false, operation = operation, error = null)
                        }
                    }
                }
        }
    }

    private fun delete() {
        val operation = state.value.operation ?: return
        viewModelScope.launch(Dispatchers.IO) {
            try {
                deleteTransactionUseCase(operation)
                // No NavigateBack here: the observed Flow emits null after the
                // delete, and observeOperation() closes the screen from there.
            } catch (e: Exception) {
                delegate.updateState { it.copy(error = e.message ?: "Failed to delete transaction") }
            }
        }
    }

    init {
        observeOperation()
    }
}

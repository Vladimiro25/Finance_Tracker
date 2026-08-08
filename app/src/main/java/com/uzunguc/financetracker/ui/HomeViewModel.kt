package com.uzunguc.financetracker.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uzunguc.financetracker.DateFilter
import com.uzunguc.financetracker.TypeOperation
import com.uzunguc.financetracker.delegate.DefaultMviDelegate
import com.uzunguc.financetracker.domain.model.Operation
import com.uzunguc.financetracker.domain.usecase.operation.GetOperationsUseCase
import com.uzunguc.financetracker.mvi.MviController
import java.math.BigDecimal
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class HomeViewModel @Inject constructor(
    private val getOperationsUseCase: GetOperationsUseCase,
) : ViewModel(), MviController<HomeUiState, HomeUiEvent> {
    private val delegate = DefaultMviDelegate(HomeUiState())
    override val state = delegate.state

    override fun sendEvent(event: HomeUiEvent) {
        when (event) {
            HomeUiEvent.AddTransactionClick -> {
                TODO("Navigate to add transaction screen")
            }

            HomeUiEvent.LoadHomeData -> {
                loadHomeData()
            }

            is HomeUiEvent.SelectDateFilter -> {
                filterData(filter = event.filter)
            }

            HomeUiEvent.ErrorShown -> {
                delegate.updateState { it.copy(error = null) }
            }
        }
    }

    private fun loadHomeData() {
        delegate.updateState { it.copy(isLoading = true, error = null) }
        viewModelScope.launch(Dispatchers.IO) {
            getOperationsUseCase()
                .catch { throwable ->
                    delegate.updateState { it.copy(isLoading = false, error = throwable.message) }
                }
                .collect { operations ->
                    val income = operations.sumByType(TypeOperation.INCOME)
                    val outcome = operations.sumByType(TypeOperation.EXPENSE)
                    delegate.updateState {
                        it.copy(
                            isLoading = false,
                            operations = operations,
                            income = income,
                            outcome = outcome,
                            overallBalance = income - outcome,
                            error = null
                        )
                    }
                }
        }
    }

    private fun List<Operation>.sumByType(type: TypeOperation): BigDecimal =
        filter { it.type == type }.fold(BigDecimal.ZERO) { acc, operation -> acc + operation.sum }

    private fun filterData(filter: DateFilter) {
        //TODO: implement filter logic
        Log.d("HomeViewModel", "Filtering data by: $filter")
    }

    init {
        sendEvent(HomeUiEvent.LoadHomeData)
    }
}


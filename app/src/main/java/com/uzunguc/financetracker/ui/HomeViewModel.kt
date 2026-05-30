package com.uzunguc.financetracker.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.uzunguc.financetracker.delegate.DefaultMviDelegate
import com.uzunguc.financetracker.mvi.MviController
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel : ViewModel(), MviController<HomeUiState, HomeUiEvent> {

    private val mviDelegate =
        DefaultMviDelegate<HomeUiState, HomeUiEvent>(initialState = HomeUiState.Loading)
    override val state: StateFlow<HomeUiState> = mviDelegate.state
    override fun sendEvent(event: HomeUiEvent) {
        when(event){
            HomeUiEvent.AddTransactionClick -> {
                TODO("Navigate to add transaction screen")
            }
            HomeUiEvent.LoadHomeData -> {
                loadHomeData()
            }
            is HomeUiEvent.NavigateToTransactionDetails -> {

            }
            is HomeUiEvent.SelectDateFilter -> {

            }
        }
    }

    private fun loadHomeData() {
        TODO("Implement data loading logic via repository")
    }
    private fun navigateToTransactionDetails(transactionId:Int){
        // TODO: implement navigation
        Log.d("HomeViewModel","Navigationg to details for transaction: $transactionId")
    }

    private fun filterData(filter: DateFilter){
        //TODO: implement filter logic
        Log.d("HomeViewModel", "Filtering data by: $filter")
    }

    init {
        sendEvent(HomeUiEvent.LoadHomeData)
    }
}

enum class DateFilter {
    DAILY, WEEKLY, MONTHLY, YEARLY
}
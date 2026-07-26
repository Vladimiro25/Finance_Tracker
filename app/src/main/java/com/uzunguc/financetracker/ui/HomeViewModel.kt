package com.uzunguc.financetracker.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.uzunguc.financetracker.DateFilter
import com.uzunguc.financetracker.delegate.DefaultMviDelegate
import com.uzunguc.financetracker.mvi.MviController
import javax.inject.Inject


class HomeViewModel @Inject constructor() : ViewModel(), MviController<HomeUiState, HomeUiEvent> {
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
        }
    }

    private fun loadHomeData() {
        TODO("Implement data loading logic via repository")
    }

    private fun filterData(filter: DateFilter) {
        //TODO: implement filter logic
        Log.d("HomeViewModel", "Filtering data by: $filter")
    }

    init {
        sendEvent(HomeUiEvent.LoadHomeData)
    }
}


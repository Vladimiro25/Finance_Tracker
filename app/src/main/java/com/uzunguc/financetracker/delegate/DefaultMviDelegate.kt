package com.uzunguc.financetracker.delegate

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultMviDelegate<State>(initialState: State) {
    private val _state = MutableStateFlow(initialState)
    val state: StateFlow<State> = _state.asStateFlow()

    fun updateState(reducer: (State) -> State) {
        _state.value = reducer(_state.value)
    }
}
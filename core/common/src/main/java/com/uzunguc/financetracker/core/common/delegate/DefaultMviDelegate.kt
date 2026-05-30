package com.uzunguc.financetracker.core.common.delegate

import com.uzunguc.financetracker.core.common.mvi.MviController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DefaultMviDelegate<State, Event>(initialState: State) : MviController<State, Event> {
    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<State> = _state.asStateFlow()

    override fun sendEvent(event: Event) {
        val currentState = _state.value
    }
}
package com.uzunguc.financetracker.mvi

import kotlinx.coroutines.flow.StateFlow

interface MviController<State, Event> {
    val state: StateFlow<State>

    fun sendEvent(event: Event)
}
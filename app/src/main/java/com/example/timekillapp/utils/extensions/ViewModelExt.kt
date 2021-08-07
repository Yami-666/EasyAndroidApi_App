package com.example.timekillapp.utils.extensions

import androidx.lifecycle.viewModelScope
import com.example.timekillapp.core.base.BaseViewModel
import com.example.timekillapp.core.base.IEvent
import com.example.timekillapp.core.base.ISideEffect
import com.example.timekillapp.core.base.asStateFlow
import com.rasalexman.sresult.common.extensions.emptyResult
import com.rasalexman.sresult.data.dto.SResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

inline fun <reified E : IEvent, T : SResult<*>> BaseViewModel.handleEvent(
    eventDelay: Long = 0,
    distinctUntilChanged: Boolean = false,
    flowDispatcher: CoroutineDispatcher = Dispatchers.IO,
    initialValue: SResult<*> = emptyResult(),
    onStartValue: T? = null,
    noinline onStart: (() -> Unit)? = null,
    crossinline block: suspend FlowCollector<T>.(E) -> Unit,
): StateFlow<SResult<*>> {
    return flow {
        uiEvent.collect {
            if (it is E) {
                delay(eventDelay)
                block(it)
            }
        }
    }.apply {
        if (distinctUntilChanged) distinctUntilChanged()
    }.onStart {
        onStart?.let {
            onStart()
        }
        onStartValue?.let {
            emit(onStartValue)
        }
    }.catch {
        // TODO: 07.08.2021
    }.flowOn(flowDispatcher).asStateFlow(viewModelScope) {
        initialValue
    }
}

inline fun <reified F : ISideEffect, T : SResult<*>> BaseViewModel.handleSideEffect(
    eventDelay: Long = 0,
    flowDispatcher: CoroutineDispatcher = Dispatchers.IO,
    initialValue: SResult<*> = emptyResult(),
    noinline onStart: (() -> Unit)? = null,
    crossinline block: suspend FlowCollector<T>.(F) -> Unit,
): StateFlow<SResult<*>> {
    return flow<T> {
        uiEffect.consumeEach {
            if (it is F) {
                delay(eventDelay)
                block(it)
            }
        }
    }.onStart {
        onStart?.let {
            onStart()
        }
    }.catch {

    }.flowOn(flowDispatcher).asStateFlow(viewModelScope) {
        initialValue
    }
}

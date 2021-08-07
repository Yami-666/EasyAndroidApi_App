package com.example.timekillapp.core.base

import com.rasalexman.sresult.data.dto.SResult
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

interface IBaseViewModel {
    val anyResultFlow: Flow<SResult<*>>
    val supportFlow: Flow<SResult<*>>

    val uiEvent: MutableSharedFlow<IEvent>
    val uiEffect: Channel<ISideEffect>

    fun processViewEvent(event: IEvent)
    fun processSideEffect(effect: ISideEffect)
}
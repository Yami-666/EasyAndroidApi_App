package com.example.timekillapp.core.base

import androidx.lifecycle.ViewModel
import com.rasalexman.sresult.common.extensions.emptyResult
import com.rasalexman.sresult.data.dto.SResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

abstract class BaseViewModel : ViewModel(), IBaseViewModel {
    override val anyResultFlow: Flow<SResult<*>> = MutableStateFlow<SResult<*>>(emptyResult())
    override val supportFlow: Flow<SResult<*>> = MutableStateFlow<SResult<*>>(emptyResult())

    override val uiEvent: MutableSharedFlow<IEvent> = MutableSharedFlow()
    override val uiEffect: Channel<ISideEffect> = Channel()

    override fun processViewEvent(event: IEvent) {
        uiEvent.tryEmit(event)
    }

    override fun processSideEffect(effect: ISideEffect) {
        uiEffect.trySend(effect)
    }

}


inline fun <reified T> Flow<T>.asStateFlow(
    scope: CoroutineScope,
    started: SharingStarted = SharingStarted.WhileSubscribed(),
    crossinline initialValue: () -> T,
): StateFlow<T> {
    return this.stateIn(
        scope = scope,
        started = started,
        initialValue = initialValue()
    )
}
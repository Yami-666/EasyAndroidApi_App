package com.example.timekillapp.features.example

import com.example.timekillapp.core.base.BaseViewModel
import com.example.timekillapp.domain.example.IGetExampleUseCase
import com.example.timekillapp.features.example.example_contract.ViewModelEffects
import com.example.timekillapp.features.example.example_contract.ViewModelEvents
import com.example.timekillapp.utils.extensions.handleEvent
import com.example.timekillapp.utils.extensions.handleSideEffect
import com.rasalexman.sresult.common.extensions.anySuccess
import com.rasalexman.sresult.common.extensions.loadingResult
import com.rasalexman.sresult.common.extensions.unsafeLazy
import com.rasalexman.sresult.common.typealiases.AnyResult
import com.rasalexman.sresult.data.dto.SResult
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val getExampleUseCase: IGetExampleUseCase
) : BaseViewModel() {

    override val anyResultFlow: StateFlow<SResult<*>> by unsafeLazy {
        handleEvent<ViewModelEvents, AnyResult> { event ->
            emit(loadingResult())
            val result = when (event) {
                is ViewModelEvents.ExampleEvent -> {
                    anySuccess()
                }
            }
            emit(result)
        }
    }

    override val supportFlow: StateFlow<SResult<*>> by unsafeLazy {
        handleSideEffect<ViewModelEffects, AnyResult> { effect ->
            val result = when (effect) {
                is ViewModelEffects.ToastEffect -> {
                    anySuccess()
                }
            }
            emit(result)
        }
    }

    fun onButtonClicked() {
        processViewEvent(ViewModelEvents.ExampleEvent)
    }

    fun onImageSizeChanged() {
        processSideEffect(ViewModelEffects.ToastEffect)
    }
}
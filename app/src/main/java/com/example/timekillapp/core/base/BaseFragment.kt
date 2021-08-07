package com.example.timekillapp.core.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import com.example.timekillapp.utils.extensions.handleViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<VM: BaseViewModel> : Fragment() {

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.apply {
            viewModelScope.launch {
                supportFlow.collect(::handleViewState)
                anyResultFlow.collect(::handleViewState)
            }
        }
    }
}
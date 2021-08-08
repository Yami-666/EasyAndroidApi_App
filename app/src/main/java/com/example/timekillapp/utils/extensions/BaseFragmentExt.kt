package com.example.timekillapp.utils.extensions

import com.example.timekillapp.core.base.BaseFragment
import com.example.timekillapp.core.base.BaseViewModel
import com.rasalexman.sresult.data.dto.SResult

fun <VM : BaseViewModel, T : Any> BaseFragment<VM>.handleViewState(result: SResult<T>) {
    when (result) {
        is SResult.Success -> {

        }
        is SResult.Empty -> {

        }
        is SResult.Loading -> {

        }
        is SResult.AbstractFailure.Error -> {

        }
        else -> Unit
    }
}
package com.example.timekillapp.utils.extensions

import com.example.timekillapp.core.base.BaseFragment
import com.rasalexman.sresult.data.dto.SResult

fun <T : Any> BaseFragment.handleViewState(result: SResult<T>) {
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
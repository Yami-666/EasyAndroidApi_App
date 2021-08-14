package com.example.timekillapp.features.example.example_contract

import com.example.core.base.ISideEffect

sealed class ViewModelEffects : ISideEffect {
    object ToastEffect : ViewModelEffects()
}
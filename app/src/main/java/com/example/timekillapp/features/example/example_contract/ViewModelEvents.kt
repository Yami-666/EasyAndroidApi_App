package com.example.timekillapp.features.example.example_contract

import com.example.core.base.IEvent

sealed class ViewModelEvents : IEvent {
    object ExampleEvent : ViewModelEvents()
}

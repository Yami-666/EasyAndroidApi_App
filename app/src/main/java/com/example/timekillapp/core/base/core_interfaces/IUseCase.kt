package com.example.timekillapp.core.base.core_interfaces

import kotlinx.coroutines.flow.Flow

interface IUseCase {
    interface In<T> {
        suspend operator fun invoke(param: T)
    }

    interface Out<V> {
        suspend operator fun invoke(): V
    }

    interface InOut<T, V> {
        suspend operator fun invoke(param: T): V
    }

    interface FlowOut<V> {
        operator fun invoke() : Flow<V>
    }

    interface FlowInOut<T, V> {
        operator fun invoke(param: T): Flow<V>
    }
}
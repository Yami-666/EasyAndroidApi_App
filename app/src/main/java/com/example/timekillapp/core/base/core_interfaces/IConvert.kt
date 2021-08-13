package com.example.timekillapp.core.base.core_interfaces

// Use for mapping as extension functions
interface IConvert {
    interface To<in I, out O> {
        fun I.map(): O
    }

    interface WithParams<P, in I, out O> {
        fun I.map(params: P): O
    }
}
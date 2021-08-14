package com.example.core.base.core_interfaces

// Use for mapping as objects "from-to"
interface IMapper {
    interface To<in I, out O> {
        fun map(data: I): O
    }

    interface WithParams<P, I, O> {
        fun map(params: P, data: I): O
    }
}
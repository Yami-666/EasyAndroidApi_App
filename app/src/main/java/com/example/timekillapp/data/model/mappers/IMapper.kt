package com.example.timekillapp.data.model.mappers

interface IMapper<I, O> {
    fun map(params: I): O
}
package com.example.core.di.modules

import com.example.timekillapp.utils.resources.IStringManager
import com.example.timekillapp.utils.resources.StringManager
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface UtilitiesDependencies {
    @Provides
    fun bindStringManager(it: StringManager): IStringManager
}
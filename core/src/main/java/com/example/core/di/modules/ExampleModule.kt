package com.example.core.di.modules

import com.example.timekillapp.data.local.ExampleLocalDataSource
import com.example.timekillapp.data.remote.ExampleRemoteDataSource
import com.example.timekillapp.data.repository.ExampleRepository
import com.example.timekillapp.data.repository.IExampleLocalDataSource
import com.example.timekillapp.data.repository.IExampleRemoteDataSource
import com.example.timekillapp.domain.example.GetExampleUseCase
import com.example.timekillapp.domain.example.IExampleRepository
import com.example.timekillapp.domain.example.IGetExampleUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class ExampleModule {

    @Binds
    abstract fun bindGetExampleUseCase(it: GetExampleUseCase): IGetExampleUseCase

    @Binds
    abstract fun bindExampleLocalDataSource(it: ExampleLocalDataSource): IExampleLocalDataSource

    @Binds
    abstract fun bindExampleRemoteDataSource(it: ExampleRemoteDataSource): IExampleRemoteDataSource
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ExampleSingletonModule {

    @Binds
    abstract fun bindExampleRepository(it: ExampleRepository): IExampleRepository
}
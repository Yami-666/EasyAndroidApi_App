package com.example.data.remote

import com.example.data.remote.services.IExampleService
import com.example.data.repository.IExampleRemoteDataSource
import com.rasalexman.sresult.common.extensions.toSuccessResult
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject

internal class ExampleRemoteDataSource @Inject constructor(
    private val exampleService: IExampleService
) : IExampleRemoteDataSource {
    override suspend fun getExample(): SResult<String> {
        return exampleService.getExample().toSuccessResult()
    }
}
package com.example.data.repository

import com.example.core.base.core_interfaces.IRemoteDataSource
import com.rasalexman.sresult.data.dto.SResult

interface IExampleRemoteDataSource : IRemoteDataSource {
    suspend fun getExample(): SResult<String>
}
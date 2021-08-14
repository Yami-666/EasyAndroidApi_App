package com.example.timekillapp.data.repository

import com.example.timekillapp.core.base.core_interfaces.IRemoteDataSource
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject

interface IExampleRemoteDataSource : IRemoteDataSource {
    suspend fun getExample(): SResult<String>
}
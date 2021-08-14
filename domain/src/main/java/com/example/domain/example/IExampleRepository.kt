package com.example.domain.example

import com.example.core.base.core_interfaces.IBaseRepository
import com.example.data.repository.IExampleLocalDataSource
import com.example.data.repository.IExampleRemoteDataSource
import com.rasalexman.sresult.data.dto.SResult

interface IExampleRepository : IBaseRepository<IExampleRemoteDataSource, IExampleLocalDataSource> {
    suspend fun getExample(): SResult<String>
}
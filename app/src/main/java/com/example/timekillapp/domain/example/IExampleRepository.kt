package com.example.timekillapp.domain.example

import com.example.timekillapp.core.base.core_interfaces.IBaseRepository
import com.example.timekillapp.data.repository.IExampleLocalDataSource
import com.example.timekillapp.data.repository.IExampleRemoteDataSource
import com.rasalexman.sresult.data.dto.SResult

interface IExampleRepository : IBaseRepository<IExampleRemoteDataSource, IExampleLocalDataSource> {
    suspend fun getExample(): SResult<String>
}
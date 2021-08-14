package com.example.data.repository

import com.example.core.base.core_interfaces.ILocalDataSource
import com.rasalexman.sresult.data.dto.SResult

interface IExampleLocalDataSource : ILocalDataSource {
    suspend fun getExampleCache(): SResult<String>
}
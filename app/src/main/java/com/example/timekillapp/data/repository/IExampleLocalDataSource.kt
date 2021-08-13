package com.example.timekillapp.data.repository

import com.example.timekillapp.core.base.core_interfaces.ILocalDataSource
import com.rasalexman.sresult.data.dto.SResult

interface IExampleLocalDataSource : ILocalDataSource {
    suspend fun getExampleCache(): SResult<String>
}
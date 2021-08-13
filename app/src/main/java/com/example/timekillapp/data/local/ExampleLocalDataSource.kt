package com.example.timekillapp.data.local

import com.example.timekillapp.data.local.dao.IExampleDao
import com.example.timekillapp.data.repository.IExampleLocalDataSource
import com.rasalexman.sresult.common.extensions.doAsync
import com.rasalexman.sresult.common.extensions.toSuccessResult
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject

internal class ExampleLocalDataSource @Inject constructor(
    private val dao: IExampleDao
): IExampleLocalDataSource {
    override suspend fun getExampleCache(): SResult<String> = doAsync {
        dao.getExampleCache().toSuccessResult()
    }
}
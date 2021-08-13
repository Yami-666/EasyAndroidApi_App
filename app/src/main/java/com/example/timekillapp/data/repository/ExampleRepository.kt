package com.example.timekillapp.data.repository

import com.example.timekillapp.domain.example.IExampleRepository
import com.rasalexman.sresult.common.extensions.orIfNull
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject

internal class ExampleRepository @Inject constructor(
    override val localDataSource: IExampleLocalDataSource,
    override val remoteDataSource: IExampleRemoteDataSource
) : IExampleRepository {
    override suspend fun getExample(): SResult<String> {
        return localDataSource.getExampleCache().orIfNull {
            remoteDataSource.getExample()
        }
    }
}

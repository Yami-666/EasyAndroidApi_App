package com.example.data.repository

import com.example.domain.example.IExampleRepository
import com.rasalexman.sresult.common.extensions.orIfNull
import com.rasalexman.sresult.data.dto.SResult

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

package com.example.timekillapp.domain.example

import com.example.timekillapp.core.base.core_interfaces.IUseCase
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject


internal class GetExampleUseCase @Inject constructor(
    private val repository: IExampleRepository,
) : IGetExampleUseCase {
    override suspend fun invoke(param: String): SResult<String> {
        return repository.getExample()
    }
}

interface IGetExampleUseCase : IUseCase.InOut<String, SResult<String>>
package com.example.timekillapp.domain.example

import com.example.timekillapp.domain.IUseCase
import com.rasalexman.sresult.data.dto.SResult
import javax.inject.Inject

class GetExampleUseCase @Inject constructor(

) : IGetExampleUseCase {
    override suspend fun invoke(param: String): SResult<String> {
        TODO("Not yet implemented")
    }
}

interface IGetExampleUseCase : IUseCase.InOut<String, SResult<String>>
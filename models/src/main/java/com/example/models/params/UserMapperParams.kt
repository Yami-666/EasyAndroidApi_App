package com.example.models.params

import com.example.models.pojo_model.Passport
import com.example.models.pojo_model.UserModel

data class UserMapperParams(
    val user: UserModel,
    val passport: Passport
)

package com.example.timekillapp.data.repository

import com.example.timekillapp.data.local.ILocalDataSource

interface ILocalRepository<out L: ILocalDataSource> {
    val localDataSource: L
}
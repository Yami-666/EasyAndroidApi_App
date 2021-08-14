package com.example.core.base.core_interfaces

interface ILocalRepository<out L: ILocalDataSource> {
    val localDataSource: L
}
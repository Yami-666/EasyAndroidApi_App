package com.example.timekillapp.core.base.core_interfaces

interface ILocalRepository<out L: ILocalDataSource> {
    val localDataSource: L
}
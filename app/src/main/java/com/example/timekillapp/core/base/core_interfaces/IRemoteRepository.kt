package com.example.timekillapp.core.base.core_interfaces

interface IRemoteRepository<out R: IRemoteDataSource> {
    val remoteDataSource: R
}
package com.example.timekillapp.data.repository

import com.example.timekillapp.data.remote.IRemoteDataSource

interface IRemoteRepository<out R: IRemoteDataSource> {
    val remoteDataSource: R
}
package com.example.timekillapp.data.repository

import com.example.timekillapp.data.local.ILocalDataSource
import com.example.timekillapp.data.remote.IRemoteDataSource

interface IBaseRepository<R : IRemoteDataSource, L : ILocalDataSource> :
    IRemoteRepository<R>, ILocalRepository<L>
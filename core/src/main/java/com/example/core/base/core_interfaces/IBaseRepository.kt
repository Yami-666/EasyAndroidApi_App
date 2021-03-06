package com.example.core.base.core_interfaces

interface IBaseRepository<R : IRemoteDataSource, L : ILocalDataSource> :
    IRemoteRepository<R>, ILocalRepository<L>
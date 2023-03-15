package com.test.fitpeotest.di

import com.test.fitpeotest.network.repo.DataRepoImpl
import com.test.fitpeotest.network.repo.DataRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {

    @Binds
    abstract fun bindDatRepository(dataRepoImpl: DataRepoImpl): DataRepository
}
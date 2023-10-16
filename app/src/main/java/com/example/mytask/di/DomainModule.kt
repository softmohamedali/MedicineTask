package com.example.mytask.di

import com.example.mytask.data.remote.RemoteDataSource
import com.example.mytask.data.repo.RepoImp
import com.example.mytask.domain.abstractions.LocalDataSource
import com.example.mytask.domain.abstractions.MedicineApi
import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.usecases.GetUserMedicineUseCase
import com.example.mytask.domain.usecases.GetUsersUseCase
import com.example.mytask.domain.usecases.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providedRepo(): MedicineApi = RemoteDataSource()

    @Provides
    @Singleton
    fun provideRepo(
        localDataSource: LocalDataSource,
        remoteDataSource: MedicineApi
    ): Repo = RepoImp(localDataSource,remoteDataSource)


    @Provides
    @Singleton
    fun provideget(
        repo: Repo
    ): GetUsersUseCase = GetUsersUseCase(repo)

    @Provides
    @Singleton
    fun provideinsert(
        repo: Repo
    ): LoginUseCase = LoginUseCase(repo)

    @Provides
    @Singleton
    fun getUserMedicineUseCase(
        repo: Repo
    ): GetUserMedicineUseCase = GetUserMedicineUseCase(repo)



}
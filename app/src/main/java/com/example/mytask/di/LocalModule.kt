package com.example.mytask.di

import android.content.Context
import androidx.room.Room
import com.example.mytask.data.local.LocalDataSourceImp
import com.example.mytask.data.local.MyDao
import com.example.mytask.data.local.MyDataBase
import com.example.mytask.domain.abstractions.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): MyDataBase {
        return Room.databaseBuilder(
            context,
            MyDataBase::class.java,
            "mydatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMyDao(
        dataBase: MyDataBase
    ): MyDao =dataBase.myDao()


    @Provides
    @Singleton
    fun provideLocalDataSource(
        dao: MyDao
    ): LocalDataSource = LocalDataSourceImp(dao)

}
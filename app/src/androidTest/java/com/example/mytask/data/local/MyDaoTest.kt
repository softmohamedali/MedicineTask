package com.example.mytask.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.mytask.data.local.entitys.toUserEntity
import com.example.mytask.domain.models.User
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class MyDaoTest {


    //that to make junit execute code line after line
    @JvmField
    @Rule
    val instentsTaskExecutor=InstantTaskExecutorRule()

    private lateinit var dataBase: MyDataBase
    private lateinit var myDao:MyDao


    @Before
    fun before(){
        dataBase=Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            MyDataBase::class.java
        ).allowMainThreadQueries().build()

        myDao=dataBase.myDao()

    }

    @After
    fun tearDown(){
        dataBase.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @FlowPreview
    @Test
    fun testInsertUserAndGetTheSameUser()= runBlockingTest{
        val user=User()
        myDao.insertUser(user.toUserEntity())

        assertThat(myDao.getUsers().first().size).isEqualTo(1)
        assertThat(myDao.getUsers().first()[0]).isEqualTo(user.toUserEntity())
    }
}
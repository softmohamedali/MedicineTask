package com.example.mytask.domain.usecases

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mytask.domain.abstractions.Repo
import com.example.mytask.domain.models.User
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.*



@OptIn(ExperimentalCoroutinesApi::class)
class TestGetUsersUseCase {


    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()


    private lateinit var useCases: GetUsersUseCase
    private lateinit var repositry: Repo

    @Before
    fun setUp() {
        repositry= mock<Repo>()
        useCases= GetUsersUseCase(repositry)
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `verify if repository call getUsers fun`()= runTest{
        val users = listOf(
            User(),
            User()
        )
        whenever(repositry.getUsers()).thenReturn(flowOf(users))
        useCases().collect{}
        verify(repositry).getUsers()

    }



}



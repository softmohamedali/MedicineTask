package com.example.mytask.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mytask.data.local.entitys.UserEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MyDao {

    @Query("SELECT * FROM users")
    fun getUsers():Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(userEntity: UserEntity)

}
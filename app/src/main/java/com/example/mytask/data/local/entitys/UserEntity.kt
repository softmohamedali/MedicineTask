package com.example.mytask.data.local.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mytask.core.utils.Constants
import kotlinx.serialization.Serializable



@Entity(tableName = Constants.USERS_TABLE_NAME)
@Serializable
data class UserEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int=-1,
    val name:String="",
    val addAt:String="",
    val password:String="",
)

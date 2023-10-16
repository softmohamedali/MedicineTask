package com.example.mytask.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mytask.data.local.MyDao
import com.example.mytask.data.local.entitys.UserEntity

@Database(
    entities = [UserEntity::class], version = 1, exportSchema = false
)
abstract class MyDataBase:RoomDatabase() {

    abstract fun myDao(): MyDao

}
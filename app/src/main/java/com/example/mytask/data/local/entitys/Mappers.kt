package com.example.mytask.data.local.entitys

import com.example.mytask.domain.models.User


fun UserEntity.toUser(): User {
    return User(
        name, addAt, password
    )
}

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        name = email,
        addAt =addAt,
        password =password,
    )
}
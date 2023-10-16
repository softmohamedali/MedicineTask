package com.example.mytask.data.local.entitys

import com.example.mytask.domain.models.User
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class UserMapperTest {
    @Test
    fun `userEntity toUser should map the same object`() {
        val userEntity = UserEntity(
            id = 1,
            name = "jhon",
            addAt = "2002/3/3",
            password = "123",
        )

        val user = User(
            email = "jhon",
            addAt = "2002/3/3",
            password = "123",
        )
        assertThat(userEntity.toUser()).isEqualTo(user)
    }
}
package com.example.mytask.core.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


object DateTimeFormatted {


    fun getCurrentTodayDate(): String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return current.format(formatter)
    }
}
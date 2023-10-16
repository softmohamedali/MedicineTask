package com.example.mytask.presentation.my_comonents

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun LoadingLayer() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.Black.copy(0.5f)
    ) {
        Center { CircularProgressIndicator() }
    }
}
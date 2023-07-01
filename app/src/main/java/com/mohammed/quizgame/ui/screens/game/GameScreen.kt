package com.mohammed.quizgame.ui.screens.game

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun GameScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        Text(text = "game screen")

    }
}
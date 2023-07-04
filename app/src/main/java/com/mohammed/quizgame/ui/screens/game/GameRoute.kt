package com.mohammed.quizgame.ui.screens.game

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammed.quizgame.Screen


fun NavGraphBuilder.gameRoute(navController: NavController) {
    composable(Screen.GameScreen.route) { GameScreen(navController) }
}
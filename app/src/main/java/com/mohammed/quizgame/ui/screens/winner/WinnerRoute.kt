package com.mohammed.quizgame.ui.screens.winner

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.winnerRoute(navController: NavController) {
    composable(
        route = "${Screen.WinnerScreen.route}/{score}",
        arguments = listOf(navArgument("score") { NavType.StringType })
    ) { WinnerScreen(navController = navController) }

}
package com.mohammed.quizgame.ui.screens.loser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.loserRoute(navController: NavController) {

    composable(
        route = "${Screen.LoserScreen.route}/{score}",
        arguments = listOf(navArgument("score") { NavType.StringType })
    ) { LoserScreen(navController = navController) }

}
package com.mohammed.quizgame

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mohammed.quizgame.ui.screens.configuration.configurationRoute
import com.mohammed.quizgame.ui.screens.game.gameRoute
import com.mohammed.quizgame.ui.screens.winner.winnerRoute


@Composable
fun QuizGameNavGraph (navController: NavHostController){

    NavHost(navController = navController, startDestination = Screen.ConfigurationScreen.route) {

        configurationRoute(navController)
        gameRoute(navController)
        winnerRoute(navController)
    }
}
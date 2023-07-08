package com.mohammed.quizgame

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mohammed.quizgame.ui.screens.configuration.configurationRoute
import com.mohammed.quizgame.ui.screens.game.gameRoute
import com.mohammed.quizgame.ui.screens.loser.loserRoute
import com.mohammed.quizgame.ui.screens.splash.splashRoute
import com.mohammed.quizgame.ui.screens.winner.winnerRoute


@Composable
fun QuizGameNavGraph (navHostController: NavHostController){

    NavHost(navController = navHostController, startDestination = Screen.SplashScreen.route) {

        configurationRoute(navHostController)
        gameRoute(navHostController)
        winnerRoute(navHostController)
        splashRoute(navHostController)
        loserRoute(navHostController)
    }
}
package com.mohammed.quizgame

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import com.mohammed.quizgame.ui.screens.configuration.configurationRoute


@Composable
fun QuizGameNavGraph (navController: NavHostController){

    NavHost(navController = navController, startDestination = Screen.ConfigurationScreen.route) {

        configurationRoute(navController)
    }
}
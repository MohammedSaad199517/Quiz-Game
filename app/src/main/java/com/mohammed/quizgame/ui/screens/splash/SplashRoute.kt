package com.mohammed.quizgame.ui.screens.splash

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.splashRoute(navController: NavController) {
    composable(Screen.SplashScreen.route){ SplashScreen(navController)}
}
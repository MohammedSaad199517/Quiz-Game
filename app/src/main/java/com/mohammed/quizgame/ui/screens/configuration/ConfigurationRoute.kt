package com.mohammed.quizgame.ui.screens.configuration

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.configurationRoute(navController: NavController){
    composable(Screen.ConfigurationScreen.route) { ConfigurationScreen(navController) }
}
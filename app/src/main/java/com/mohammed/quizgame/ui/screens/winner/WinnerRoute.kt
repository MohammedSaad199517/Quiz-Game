package com.mohammed.quizgame.ui.screens.winner

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.winnerRoute (navController: NavController){
    composable(Screen.WinnerScreen.route){ WinnerScreen(navController = navController)}
    
}
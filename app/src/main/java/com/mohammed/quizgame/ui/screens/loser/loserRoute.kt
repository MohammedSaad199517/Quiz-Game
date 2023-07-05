package com.mohammed.quizgame.ui.screens.loser

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mohammed.quizgame.Screen

fun NavGraphBuilder.loserRoute(navController: NavController){
    composable(Screen.LoserScreen.route){ LoserScreen(navController)}

}
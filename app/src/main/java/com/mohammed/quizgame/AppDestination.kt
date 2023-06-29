package com.mohammed.quizgame

sealed class Screen(
    val route: String,
) {

    object ConfigurationScreen : Screen(route = "ConfigurationScreen")

    object GameScreen : Screen(route = "GameScreen")

}
package com.mohammed.quizgame.ui.screens.game

data class GameUISate (
    val question:List<String> = emptyList(),
    val totalQuestions:Int =0,
    val currentQuestion:Int =0,
    val correctAnswer:String ="",
    val wrongAnswer:List<String> = emptyList(),
    val isLoading: Boolean = true,
    val errors: String? = null

        )
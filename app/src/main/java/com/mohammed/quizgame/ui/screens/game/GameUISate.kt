package com.mohammed.quizgame.ui.screens.game

data class GameUISate(
    val question: String = "",
    val time: Long = 0L,
    val totalQuestions: Int = 0,
    val currentQuestion: Int = 1,
    val currentScore: Int = 0,
    val answers: List<HashMap<String, String>> = emptyList(),
    val isLoading: Boolean = true,
    val errors: String? = null

)
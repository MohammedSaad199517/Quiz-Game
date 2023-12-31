package com.mohammed.quizgame.ui.screens.game

import com.mohammed.quizgame.domain.models.Game

data class GameUISate(
    val quiz: List<Game> = emptyList(),
    val question: String = "",
    val time: Long = 0L,
    val totalQuestions: Int = 0,
    val currentQuestionNumber: Int = 1,
    val isAnswerSelected: Boolean = false,
    val isAnswerCorrect: Boolean? = null,
    val answerSelectedId: Int? = null,
    val currentScore: Int = 0,
    val answers: List<HashMap<String, String>> = emptyList(),
    val isLoading: Boolean = true,
    val errors: String? = null

)
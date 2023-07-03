package com.mohammed.quizgame.ui.screens.game

data class GameUISate(
    val question: String = "",
    val time: Long = 0L,
    val totalQuestions: Int = 0,
    val currentQuestionNumber: Int = 1,
    val isAnswerCorrect:Boolean?=null,
    val answerSelectedId:Int?=null,
    val currentScore: Int = 0,
    val answers: List<HashMap<String, String>> = emptyList(),
    val isLoading: Boolean = true,
    val errors: String? = null

)
package com.mohammed.quizgame.domain.models

data class Game(
    val questionId: String,
    val category: String,
    val answers: List<HashMap<String, String>>,
    val question: String,
    val difficulty: String
)
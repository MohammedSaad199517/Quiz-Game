package com.mohammed.quizgame.domain.models

data class Game (
    val questionId: String,
    val category: String,
    val correctAnswer: String,
    val firstIncorrectAnswers: String,
    val secondIncorrectAnswers: String,
    val thirdIncorrectAnswers: String,
    val question: String,
    val difficulty: String
        )
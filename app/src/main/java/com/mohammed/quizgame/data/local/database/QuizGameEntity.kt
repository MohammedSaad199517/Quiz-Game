package com.mohammed.quizgame.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QUIZ_GAME_TABLE")
data class QuizGameEntity (
    @PrimaryKey
    val questionId: String,
    val category: String,
    val correctAnswer: String,
    val firstIncorrectAnswers: String,
    val secondIncorrectAnswers: String,
    val thirdIncorrectAnswers: String,
    val question: String,
    val difficulty: String
)
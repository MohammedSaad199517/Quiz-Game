package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.domain.models.Configuration


interface QuizGameRepository{
    suspend fun getAllQuestions():Result<List<Configuration>>

}
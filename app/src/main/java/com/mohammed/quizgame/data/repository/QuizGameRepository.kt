package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.data.local.QuizGameEntity


interface QuizGameRepository{


    suspend fun getAllCachedQuestions(): List<QuizGameEntity>

    suspend fun fetchQuizAndCache(): Result<List<QuizGameEntity>>

}
package com.mohammed.quizgame.data.repository.quiz

import com.mohammed.quizgame.data.local.database.QuizGameEntity


interface QuizRepository{


    suspend fun getAllCachedQuestions(): List<QuizGameEntity>

    suspend fun fetchQuizAndCache(): Result<List<QuizGameEntity>>

}

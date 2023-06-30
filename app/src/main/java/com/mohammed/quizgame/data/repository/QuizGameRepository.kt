package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.data.response.Questions
import retrofit2.Response


interface QuizGameRepository{
    suspend fun getAllQuestions():Response<Questions>

}
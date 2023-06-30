package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.data.service.ApiService
import javax.inject.Inject


class QuizGameRepositoryImp  @Inject constructor(
   private val apiService: ApiService
):QuizGameRepository  {
    override suspend fun getAllQuestions()= apiService.getAllQuestion()



}
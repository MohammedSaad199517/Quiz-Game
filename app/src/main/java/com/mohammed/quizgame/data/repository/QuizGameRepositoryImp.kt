package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.data.service.ApiService
import com.mohammed.quizgame.domain.models.Configuration
import com.mohammed.quizgame.utils.toConfiguration
import javax.inject.Inject


class QuizGameRepositoryImp  @Inject constructor(
   private val apiService: ApiService
):QuizGameRepository  {
    override suspend fun getAllQuestions():Result<List<Configuration>>{
        try {
            val response = apiService.getAllQuestion()
            if (response.isSuccessful){
                val items = response.body()?.map { it.toConfiguration() }
                items?.let {
                    return Result.success(items)
                }

            }
            return Result.failure(Exception("Failed to retrieve data"))
        }catch (e:Exception){
            return Result.failure(e)
        }

    }



}
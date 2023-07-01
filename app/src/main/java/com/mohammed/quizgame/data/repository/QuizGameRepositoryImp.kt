package com.mohammed.quizgame.data.repository

import com.mohammed.quizgame.data.local.QuizGameDao
import com.mohammed.quizgame.data.local.QuizGameEntity
import com.mohammed.quizgame.data.remote.sevice.ApiService
import com.mohammed.quizgame.utils.toQuizGameEntity
import javax.inject.Inject


class QuizGameRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: QuizGameDao
) : QuizGameRepository {


    override suspend fun getAllCachedQuestions(): List<QuizGameEntity> {
        return dao.getAllQuestions()
    }

    override suspend fun fetchQuizAndCache(): Result<List<QuizGameEntity>> {
        try {
            val response = apiService.getAllQuestion()
            if (response.isSuccessful) {
                val items = response.body()?.map { it.toQuizGameEntity() }
                items?.let {
                    return Result.success(items)
                }

            }
            return Result.failure(Exception("Failed to retrieve data"))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }


}
package com.mohammed.quizgame.data.repository.quiz

import android.util.Log
import com.mohammed.quizgame.data.local.database.QuizGameDao
import com.mohammed.quizgame.data.local.database.QuizGameEntity
import com.mohammed.quizgame.data.remote.ApiService
import com.mohammed.quizgame.utils.toQuizGameEntity
import javax.inject.Inject


class QuizRepositoryImp @Inject constructor(
    private val apiService: ApiService,
    private val dao: QuizGameDao,

    ) : QuizRepository {


    override suspend fun getAllCachedQuestions(): List<QuizGameEntity> {
        Log.i("data","${dao.getAllQuestions()}")
        return dao.getAllQuestions()
    }

    override suspend fun fetchQuizAndCache(): Result<List<QuizGameEntity>> {
        try {
            val response = apiService.getAllQuestion()
            if (response.isSuccessful) {
                val items = response.body()?.map { it.toQuizGameEntity() }
                Log.i("repo","${items?.size}")
                items?.let {
                    dao.insertAllQuestions(it)
                    return Result.success(it)
                }

            }
            return Result.failure(Exception("Failed to retrieve data"))
        } catch (e: Exception) {
            return Result.failure(e)
        }
    }

}
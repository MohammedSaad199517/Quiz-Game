package com.mohammed.quizgame.data.remote.sevice

import com.mohammed.quizgame.data.remote.dto.QuestionsDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("questions")
    suspend fun getAllQuestion():Response<QuestionsDto>

}
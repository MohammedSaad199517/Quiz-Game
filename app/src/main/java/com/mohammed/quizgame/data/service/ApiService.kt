package com.mohammed.quizgame.data.service

import com.mohammed.quizgame.data.response.Questions
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("questions")
    suspend fun getAllQuestion():Response<Questions>

}
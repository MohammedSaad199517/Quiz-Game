package com.mohammed.quizgame.data.remote.dto


import com.google.gson.annotations.SerializedName

data class QuestionDto(
    @SerializedName("text")
    val text: String? = null
)
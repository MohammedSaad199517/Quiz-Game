package com.mohammed.quizgame.data.response


import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("text")
    val text: String? = null
)
package com.mohammed.quizgame.data.remote.dto


import com.google.gson.annotations.SerializedName

data class QuestionsItemDto(
    @SerializedName("category")
    val category: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("correctAnswer")
    val correctAnswer: String? = null,
    @SerializedName("incorrectAnswers")
    val incorrectAnswers: List<String?>? = null,
    @SerializedName("question")
    val question: QuestionDto? = null,
    @SerializedName("tags")
    val tags: List<String?>? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("difficulty")
    val difficulty: String? = null,
    @SerializedName("regions")
    val regions: List<Any?>? = null,
    @SerializedName("isNiche")
    val isNiche: Boolean? = null,

    )
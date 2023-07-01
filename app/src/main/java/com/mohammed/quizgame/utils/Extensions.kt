package com.mohammed.quizgame.utils

import com.mohammed.quizgame.data.response.QuestionsItem
import com.mohammed.quizgame.domain.models.Configuration

fun QuestionsItem.toConfiguration():Configuration{
    return Configuration(
        category = category!!,
        level = difficulty!!

    )
}
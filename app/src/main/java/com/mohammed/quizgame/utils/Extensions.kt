package com.mohammed.quizgame.utils

import com.mohammed.quizgame.data.local.QuizGameEntity
import com.mohammed.quizgame.data.remote.dto.QuestionsItemDto
import com.mohammed.quizgame.domain.models.Configuration

fun QuestionsItemDto.toQuizGameEntity(): QuizGameEntity {

    return QuizGameEntity(
        questionId = id!!,
        category = category!!,
        correctAnswer = correctAnswer!!,
        firstIncorrectAnswers = incorrectAnswers?.get(0)!!,
        secondIncorrectAnswers = incorrectAnswers[1]!!,
        thirdIncorrectAnswers = incorrectAnswers[2]!!,
        difficulty = difficulty!!,
        question = question?.text!!
    )
}

fun QuizGameEntity.toConfiguration(): Configuration {
    return Configuration(
        category = category
    )
}

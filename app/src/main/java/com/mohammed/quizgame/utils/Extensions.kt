package com.mohammed.quizgame.utils

import com.mohammed.quizgame.data.local.database.QuizGameEntity
import com.mohammed.quizgame.data.remote.dto.QuestionsItemDto
import com.mohammed.quizgame.domain.models.Game

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
fun QuizGameEntity.toGame(): Game {

    return Game(
        questionId = questionId,
        category = category,
        correctAnswer = correctAnswer,
        firstIncorrectAnswers = firstIncorrectAnswers,
        secondIncorrectAnswers = secondIncorrectAnswers,
        thirdIncorrectAnswers = thirdIncorrectAnswers,
        difficulty = difficulty,
        question = question
    )
}

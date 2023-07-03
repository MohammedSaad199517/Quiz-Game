package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.quiz.QuizRepository
import com.mohammed.quizgame.utils.toGame
import javax.inject.Inject

class GetQuizUseCase @Inject constructor(
    private val quizRepository: QuizRepository
) {
    suspend operator fun invoke() = quizRepository.getAllCachedQuestions().map { it.toGame() }
}
package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.quiz.QuizRepository
import javax.inject.Inject

class GetAllCategoryUseCase @Inject constructor(
    private val quizGameRepository: QuizRepository
) {
    suspend operator fun invoke() =
        quizGameRepository.getAllCachedQuestions().map { it.category }.distinct()

}
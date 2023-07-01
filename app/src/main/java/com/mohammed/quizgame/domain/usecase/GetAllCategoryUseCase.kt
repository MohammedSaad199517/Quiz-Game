package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.QuizGameRepository
import javax.inject.Inject

class GetAllCategoryUseCase @Inject constructor(
    private val quizGameRepository: QuizGameRepository
) {
    suspend operator fun invoke() =
        quizGameRepository.getAllCachedQuestions().map { it.category }.distinct()

}
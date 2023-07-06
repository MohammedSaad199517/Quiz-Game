package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.quiz.QuizRepository
import javax.inject.Inject

class GetAllCategoryUseCase @Inject constructor(
    private val quizRepository: QuizRepository,
) {
    suspend operator fun invoke(): List<String> {
        return quizRepository.getAllCachedQuestions().map { it.category }.distinct()
    }
}
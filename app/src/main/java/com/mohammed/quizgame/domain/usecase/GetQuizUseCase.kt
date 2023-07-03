package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.quiz.QuizRepository
import com.mohammed.quizgame.domain.models.Game
import com.mohammed.quizgame.utils.toGame
import javax.inject.Inject

class GetQuizUseCase @Inject constructor(
    private val quizRepository: QuizRepository,
    private val getSavedConfigurationUseCase: GetSavedConfigurationUseCase
) {
    suspend operator fun invoke(): List<Game> {
        val levelSelected = getSavedConfigurationUseCase.invoke()?.selectedLevel!!
        val categorySelected = getSavedConfigurationUseCase.invoke()?.selectedCategory!!
        return quizRepository.getAllCachedQuestions()
            .map { it.toGame() }
            .filter {
                it.difficulty == levelSelected && it.category == categorySelected
            }.shuffled()
    }
}
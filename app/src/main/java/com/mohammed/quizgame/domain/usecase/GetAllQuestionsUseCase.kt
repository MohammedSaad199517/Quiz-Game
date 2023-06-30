package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.QuizGameRepositoryImp
import javax.inject.Inject

class GetAllQuestionsUseCase @Inject constructor(
   private val quizGameRepository: QuizGameRepositoryImp
) {
    suspend operator fun invoke() = quizGameRepository.getAllQuestions()
}
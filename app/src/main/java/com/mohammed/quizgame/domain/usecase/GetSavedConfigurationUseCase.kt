package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.configuration.ConfigurationRepository
import com.mohammed.quizgame.data.repository.configuration.SavedConfiguration
import javax.inject.Inject

class GetSavedConfigurationUseCase @Inject constructor(
    private val configurationRepository: ConfigurationRepository
) {
    suspend operator fun invoke(): SavedConfiguration =
        configurationRepository.getSavedConfiguration()

}
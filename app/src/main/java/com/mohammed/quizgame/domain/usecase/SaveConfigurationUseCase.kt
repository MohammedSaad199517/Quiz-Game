package com.mohammed.quizgame.domain.usecase

import com.mohammed.quizgame.data.repository.configuration.ConfigurationRepository
import javax.inject.Inject

class SaveConfigurationUseCase @Inject constructor(
    private val configurationRepository: ConfigurationRepository) {

    suspend operator fun invoke(
        selectedCategory: String,
        selectedLevel: String,
        selectedQuantity: Int) {
        configurationRepository.saveConfiguration(
            selectedCategory,
            selectedLevel,
            selectedQuantity
        )
    }
}
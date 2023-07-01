package com.mohammed.quizgame.ui.screens.configuration

import com.mohammed.quizgame.domain.models.Configuration


data class ConfigurationUISate(
    val categories: List<Configuration> = emptyList(),
    val selectedCategory: String = "",
    val selectedLevel: String = "",
    val selectedQuantity: Int =0,
    val isLoading: Boolean = true,
    val errors: String? = null

)
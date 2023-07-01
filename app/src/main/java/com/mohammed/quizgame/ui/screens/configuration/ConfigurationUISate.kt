package com.mohammed.quizgame.ui.screens.configuration

import com.mohammed.quizgame.domain.models.Configuration

data class ConfigurationUISate(
    val response: List<Configuration> ? = null,
    val isLoading: Boolean = true,
    val errors: String? = null

)
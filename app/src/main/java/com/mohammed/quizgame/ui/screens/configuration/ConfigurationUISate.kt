package com.mohammed.quizgame.ui.screens.configuration

data class ConfigurationUISate(
    val categories: List<String> = emptyList(),
    val selectedCategory: String = "",
    val selectedLevel: String = "",
    val selectedQuantity: Int = 0,
    val isLoading: Boolean = true,
    val errors: String? = null,
    val isAlertDialogOpen:Boolean =false,
    val numberOfAvailableQuestion: Int = 0

)
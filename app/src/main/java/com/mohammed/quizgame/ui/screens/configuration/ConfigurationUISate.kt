package com.mohammed.quizgame.ui.screens.configuration

data class ConfigurationUISate(
    val categories: List<String> = emptyList(),
    val selectedCategory: String = "",
    val selectedLevel: String = "",
    val selectedQuantity: Int =0,
    val isNumberOfQuestionAvailable:Boolean?=null,
    val isLoading: Boolean = true,
    val errors: String? = null

)
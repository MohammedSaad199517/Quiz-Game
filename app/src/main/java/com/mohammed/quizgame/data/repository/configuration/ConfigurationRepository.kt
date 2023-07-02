package com.mohammed.quizgame.data.repository.configuration


interface ConfigurationRepository {
    suspend fun saveConfiguration(selectedCategory: String, selectedLevel: String, selectedQuantity: Int)
    suspend fun getSavedConfiguration(): SavedConfiguration?

}
data class SavedConfiguration(
    val selectedCategory: String,
    val selectedLevel: String,
    val selectedQuantity: Int
)
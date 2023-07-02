package com.mohammed.quizgame.ui.screens.configuration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammed.quizgame.domain.usecase.CacheQuizUseCase
import com.mohammed.quizgame.domain.usecase.GetAllCategoryUseCase
import com.mohammed.quizgame.domain.usecase.SaveConfigurationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigurationViewModel @Inject constructor(
    private val getAllCategoryUseCase: GetAllCategoryUseCase,
    private val cacheQuizUseCase: CacheQuizUseCase,
    private val saveConfigurationUseCase: SaveConfigurationUseCase,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ConfigurationUISate())
    val uiState: StateFlow<ConfigurationUISate> = _uiState


    init {


        viewModelScope.launch(Dispatchers.IO) {
            cacheQuizUseCase.invoke()
            getAllQuestions()
        }
    }

    suspend fun getAllQuestions() {

        _uiState.update {
            it.copy(
                isLoading = false,
                categories = getAllCategoryUseCase.invoke()

            )
        }

    }

    fun updateSelectedCategory(value: String) {
        _uiState.update { it.copy(selectedCategory = value) }
    }

    fun updateSelectedLevel(value: String) {
        _uiState.update { it.copy(selectedLevel = value) }
    }

    fun updateSelectedQuantity(value: Int) {
        _uiState.update { it.copy(selectedQuantity = value) }
    }

    fun saveConfig(
        selectedCategory: String,
        selectedLevel: String,
        selectedQuantity: Int
    ) {
        viewModelScope.launch {
            saveConfigurationUseCase.invoke(
                selectedCategory,
                selectedLevel,
                selectedQuantity
            )
        }

    }



}
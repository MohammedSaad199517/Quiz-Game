package com.mohammed.quizgame.ui.screens.configuration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.mohammed.quizgame.Screen
import com.mohammed.quizgame.domain.usecase.CacheQuizUseCase
import com.mohammed.quizgame.domain.usecase.GetAllCategoryUseCase
import com.mohammed.quizgame.domain.usecase.GetQuizUseCase
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
    private val getQuizUseCase: GetQuizUseCase
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

    fun chickIfNumberOfQuestionIsAvailable() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    isNumberOfQuestionAvailable = getQuizUseCase.invoke().size <= uiState.value.selectedQuantity
                )
            }
        }
    }

    fun saveConfig(
        selectedCategory: String?=null,
        selectedLevel: String?=null,
        selectedQuantity: Int?=null
    ) {
        viewModelScope.launch {
            saveConfigurationUseCase.invoke(
                selectedCategory,
                selectedLevel,
                selectedQuantity
            )
        }
    }

    fun navigateToGameScreen(navController: NavController) {
        viewModelScope.launch(Dispatchers.IO) {
            if (getQuizUseCase.invoke().size >= uiState.value.selectedQuantity) {
                viewModelScope.launch {
                    navController.navigate(Screen.GameScreen.route)
                }
            }
        }
    }
}
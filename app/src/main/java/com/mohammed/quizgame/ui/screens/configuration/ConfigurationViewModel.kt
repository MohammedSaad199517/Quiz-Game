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
    private val getQuizUseCase: GetQuizUseCase,
    ) : ViewModel() {
    private val _uiState = MutableStateFlow(ConfigurationUISate())
    val uiState: StateFlow<ConfigurationUISate> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            cacheQuizUseCase.invoke()
            getAllCategories()
            saveConfig(
                selectedCategory = _uiState.value.selectedCategory,
                selectedLevel = _uiState.value.selectedLevel,
                selectedQuantity = _uiState.value.selectedQuantity
            )

        }
    }

    private suspend fun getAllCategories() {

        _uiState.update {
            it.copy(
                isLoading = false,
                categories = getAllCategoryUseCase.invoke(),

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
        selectedCategory: String? = null,
        selectedLevel: String? = null,
        selectedQuantity: Int? = null
    ) {

        viewModelScope.launch(Dispatchers.IO) {
            saveConfigurationUseCase.invoke(
                selectedCategory,
                selectedLevel,
                selectedQuantity
            )
        }
    }

    fun updateNumberOfAvailableQuestion() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    numberOfAvailableQuestion = getQuizUseCase.invoke().size
                )
            }
        }
    }

    fun openAlertDialogIfRequireNumberOfQuestionIsNotAvailable() {
        viewModelScope.launch(Dispatchers.IO) {
            if (getQuizUseCase.invoke().size < uiState.value.selectedQuantity) {
                _uiState.update {
                    it.copy(isAlertDialogOpen = true)
                }
            }

        }
    }

    fun closeAlertDialog() {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(isAlertDialogOpen = false)
            }
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

    fun textMessage(numberOfAvailableQuestion: Int): String {
        return if (numberOfAvailableQuestion > 0) {
            "Sorry ,There is just $numberOfAvailableQuestion questions in this level of category"
        } else noQuestionsFounded
    }

    private companion object {
        const val noQuestionsFounded = "Sorry, there is no questions in this level of category  please choose another  "
    }
}
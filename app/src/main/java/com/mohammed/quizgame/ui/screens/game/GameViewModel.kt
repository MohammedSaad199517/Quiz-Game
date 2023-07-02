package com.mohammed.quizgame.ui.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammed.quizgame.domain.usecase.GetQuizUseCase
import com.mohammed.quizgame.domain.usecase.GetSavedConfigurationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getQuizUseCase: GetQuizUseCase,
    private val getSavedConfigurationUseCase: GetSavedConfigurationUseCase


) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUISate())
    val uiState: StateFlow<GameUISate> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(
                isLoading = false,
                question = getQuizUseCase.invoke().map { it.question },
                totalQuestions =getSavedConfigurationUseCase.invoke()?.selectedQuantity!!,
                currentQuestion=1,
                correctAnswer=getQuizUseCase.invoke().get(0).correctAnswer,
                wrongAnswer= listOf(
                    getQuizUseCase.invoke().get(0).firstIncorrectAnswers,
                    getQuizUseCase.invoke().get(0).secondIncorrectAnswers,
                    getQuizUseCase.invoke().get(0).thirdIncorrectAnswers,
                )


            )
            }
        }
    }

}
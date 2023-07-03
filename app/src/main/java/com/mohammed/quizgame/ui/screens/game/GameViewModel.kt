package com.mohammed.quizgame.ui.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammed.quizgame.domain.usecase.CountdownTimerUseCase
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
    private val getSavedConfigurationUseCase: GetSavedConfigurationUseCase,
    private val countdownTimerUseCase: CountdownTimerUseCase


) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUISate())
    val uiState: StateFlow<GameUISate> = _uiState


    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    totalQuestions = getSavedConfigurationUseCase.invoke()?.selectedQuantity!!,
                    question = getQuizUseCase.invoke().get(0).question,
                    answers = getQuizUseCase.invoke().get(0).answers
                )

            }

        }


    }

    fun startTimer() {
        countdownTimerUseCase.startTimer(
            totalTime = totalTime,
            onTick = { secondsRemaining ->
                viewModelScope.launch(Dispatchers.IO) {
                    _uiState.update {
                        it.copy(
                            time = secondsRemaining
                        )
                    }
                }
            },
            onFinish = {
                viewModelScope.launch(Dispatchers.IO) {
                    val currentQuestion = _uiState.value.currentQuestion
                    if (currentQuestion < getSavedConfigurationUseCase.invoke()?.selectedQuantity!!) {
                        _uiState.update {
                            it.copy(
                                currentQuestion = currentQuestion + 1,
                                question = getQuizUseCase.invoke().get(currentQuestion).question,
                                answers = getQuizUseCase.invoke().get(currentQuestion).answers

                            )
                        }

                    }

                }
            },
            interval = interval
        )
    }

    fun stopTimer() {
        countdownTimerUseCase.stopTimer()
    }

    private companion object {
        const val totalTime = 5000L
        const val interval = 1000L
    }
}
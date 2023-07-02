package com.mohammed.quizgame.ui.screens.game

import android.os.CountDownTimer
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
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getQuizUseCase: GetQuizUseCase,
    private val getSavedConfigurationUseCase: GetSavedConfigurationUseCase


) : ViewModel() {

    private val _uiState = MutableStateFlow(GameUISate())
    val uiState: StateFlow<GameUISate> = _uiState

    private var countDownTimer: CountDownTimer? = null
    private val seconds = TimeUnit.SECONDS.toMillis(60)
    var timeLeft = mutableSetOf(seconds)

    val countDownInterval = 1000L
    val timerText = mutableSetOf(timeLeft)

//    fun startTimer() {
//        viewModelScope.launch {
//            countDownTimer = object : CountDownTimer(5_000, 1_000){
//                override fun onTick(remaining: Long) {
//                    _uiState.update { it.copy(time =remaining ) }
//
//                }
//
//                override fun onFinish() {
//                    TODO("Not yet implemented")
//                }
//
//            }
//
//        }
//    }

    fun updateTimerValue(timeRemain:Int){
        viewModelScope.launch {
            _uiState.update { it.copy(
                time = timeRemain
            ) }
        }
    }
    init {
        viewModelScope.launch(Dispatchers.IO) {
//            _uiState.update {
//                it.copy(
//                    isLoading = false,
//                    question = getQuizUseCase.invoke().map { it.question },
//                    totalQuestions = getSavedConfigurationUseCase.invoke()?.selectedQuantity!!,
//                    currentQuestion = 1,
//                    correctAnswer = getQuizUseCase.invoke().get(0).correctAnswer,
//                    wrongAnswer = listOf(
//                        getQuizUseCase.invoke().get(0).firstIncorrectAnswers,
//                        getQuizUseCase.invoke().get(0).secondIncorrectAnswers,
//                        getQuizUseCase.invoke().get(0).thirdIncorrectAnswers,
//                    )
//
//
//                )
//            }
        }
    }

}
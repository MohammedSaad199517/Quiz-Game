package com.mohammed.quizgame.ui.screens.game

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.mohammed.quizgame.Screen
import com.mohammed.quizgame.domain.usecase.CountdownTimerUseCase
import com.mohammed.quizgame.domain.usecase.GetQuizUseCase
import com.mohammed.quizgame.domain.usecase.GetSavedConfigurationUseCase
import com.mohammed.quizgame.ui.theme.White87
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
            val quiz= getQuizUseCase.invoke()
            _uiState.update {
                it.copy(
                    quiz=quiz,
                    totalQuestions = getSavedConfigurationUseCase.invoke().selectedQuantity!!,
                    question = quiz.first().question,
                    answers = quiz.first().answers,
                )
            }
        }
    }

    fun startTimer(navController: NavController) {
        countdownTimerUseCase.startTimer(
            totalTime = totalTime,
            onTick = { secondsRemaining -> onTickTimer(secondsRemaining) },
            onFinish = { onFinishTimer(navController) },
            interval = interval
        )
    }

    private fun onTickTimer(secondsRemaining: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    time = secondsRemaining
                )
            }
        }
    }

    private suspend fun getNewQuestion(navController: NavController) {
        val currentQuestionNumber = _uiState.value.currentQuestionNumber
        val totalQuestions = getSavedConfigurationUseCase.invoke().selectedQuantity!!
        val isQuizNotFinish = currentQuestionNumber < totalQuestions

        if (isQuizNotFinish) {
            _uiState.update {
                it.copy(
                    currentQuestionNumber = currentQuestionNumber + 1,
                    question = _uiState.value.quiz[currentQuestionNumber].question,
                    answers = _uiState.value.quiz[currentQuestionNumber].answers,
                    isAnswerCorrect = null,
                    answerSelectedId = null,
                    isAnswerSelected = false
                )
            }
        } else finishQuiz(navController)
    }

    private fun onFinishTimer(navController: NavController) {
        viewModelScope.launch(Dispatchers.IO) {

            getNewQuestion(navController = navController)
        }
    }

    fun goToNextQuestion(navController: NavController) {

        viewModelScope.launch(Dispatchers.IO) {
            stopTimer()
            delay(2000L)
            getNewQuestion(navController = navController)
        }
    }

    private fun finishQuiz(navController: NavController) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentScore = uiState.value.currentScore
            val totalNumberOfQuizQuestion =
                getSavedConfigurationUseCase.invoke().selectedQuantity!!.toFloat()
            if (currentScore / totalNumberOfQuizQuestion.toDouble() >= 0.5) {
                navigateToWinnerScreen(navController)
            } else {
                navigateToLoserScreen(navController)
            }
        }
    }

    private fun stopTimer() {
        countdownTimerUseCase.stopTimer()
    }

    private fun navigateToWinnerScreen(navController: NavController) {
        viewModelScope.launch {
            navController.navigate("${Screen.WinnerScreen.route}/${_uiState.value.currentScore}")
        }
    }

    private fun navigateToLoserScreen(navController: NavController) {
        viewModelScope.launch {
            navController.navigate("${Screen.LoserScreen.route}/${_uiState.value.currentScore}")

        }
    }

    fun backgroundAnswerOptionButton(id: Int): Color {
        val isCorrectAnswer = _uiState.value.isAnswerCorrect
        if (isCorrectAnswer != null && id == _uiState.value.answerSelectedId) {
            return when (isCorrectAnswer) {
                false -> Color.Red
                true -> Color.Green
            }
        }
        return White87
    }

    fun getAnswerSelectedId(id: Int) {
        _uiState.update { it.copy(answerSelectedId = id) }
    }

    fun isCorrectAnswer(answerStatus: String) {
        _uiState.update {
            it.copy(
                isAnswerCorrect = answerStatus == correctAnswer,
                isAnswerSelected = true
            )
        }
    }

    fun disableButtonWhenAnswerIsSelected(id: Int): Boolean {
        if (_uiState.value.isAnswerSelected) {
            if (id == _uiState.value.answerSelectedId) {
                return true
            }
            return false
        }
        return true
    }

    fun updateScore() {
        val isAnswerCorrect = _uiState.value.isAnswerCorrect
        isAnswerCorrect?.apply {
            var currentScore = _uiState.value.currentScore
            if (isAnswerCorrect) _uiState.update {
                currentScore++
                it.copy(currentScore = currentScore)
            }
        }
    }

    fun backgroundColorTimer(time: Long): Color {
        if (time > 20) {
            return Color.Green
        }
        return Color.Red
    }

    private companion object {
        const val totalTime = 60000L
        const val interval = 1000L
        const val correctAnswer = "correctAnswer"
    }
}
package com.mohammed.quizgame.ui.screens.game

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohammed.quizgame.composable.AnswerOption
import com.mohammed.quizgame.composable.CurrentQuestion
import com.mohammed.quizgame.composable.CurrentQuestionNumber
import com.mohammed.quizgame.composable.CurrentScore
import com.mohammed.quizgame.composable.Timer

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val quiz by viewModel.uiState.collectAsState()
    val scrollState = rememberScrollState()

    GameContent(
        navController = navController,
        scrollState = scrollState,
        currentScore = quiz.currentScore,
        question = quiz.question,
        currentQuestionNumber = quiz.currentQuestionNumber,
        totalQuestions = quiz.totalQuestions,
        time = quiz.time,
        answers = quiz.answers,
        isCorrectAnswer = viewModel::isCorrectAnswer,
        getAnswerSelectedId = viewModel::getAnswerSelectedId,
        updateScore = viewModel::updateScore,
        backgroundAnswerOptionButton = viewModel::backgroundAnswerOptionButton,
        disableButtonWhenAnswerIsSelected = viewModel::disableButtonWhenAnswerIsSelected,
        startTimer = viewModel::startTimer,
    )
}

@Composable
private fun GameContent(
    scrollState: ScrollState,
    currentScore: Int,
    question: String,
    currentQuestionNumber: Int,
    totalQuestions: Int,
    time: Long,
    answers: List<HashMap<String, String>>,
    isCorrectAnswer: (answerStatus: String) -> Unit,
    getAnswerSelectedId: (id: Int) -> Unit,
    updateScore: () -> Unit,
    backgroundAnswerOptionButton: (id: Int) -> Color,
    disableButtonWhenAnswerIsSelected: (id: Int) -> Boolean,
    startTimer: (navController: NavController) -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    )
    {
        CurrentScore(currentScore)
        CurrentQuestion(question = question, currentQuestionNumber.toString())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CurrentQuestionNumber(currentQuestionNumber, totalQuestions)
            Timer(time.toString())

        }
        answers.forEach {
            val id = answers.indexOf(it)
            AnswerOption(
                answer = it,
                answerId = id,
                isCorrectAnswer = isCorrectAnswer,
                getAnswerSelectedId = getAnswerSelectedId,
                updateScore = updateScore,
                backgroundAnswerOptionButton = backgroundAnswerOptionButton,
                disableButtonWhenAnswerIsSelected = disableButtonWhenAnswerIsSelected
            )
        }
        LaunchedEffect(currentQuestionNumber) {
            startTimer(navController)
        }
    }
}
package com.mohammed.quizgame.ui.screens.game

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

    Column(modifier = Modifier.fillMaxSize().verticalScroll(state = scrollState))
    {

        CurrentScore(quiz.currentScore)

        CurrentQuestion(question = quiz.question, quiz.currentQuestionNumber.toString())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CurrentQuestionNumber(quiz.currentQuestionNumber, quiz.totalQuestions)
            Timer(quiz.time.toString())

        }

        quiz.answers.forEach {
            val id = quiz.answers.indexOf(it)
            AnswerOption(
                answer = it,
                viewModel = viewModel,
                answerId = id
            )

        }
        LaunchedEffect(quiz.currentQuestionNumber) {
            viewModel.startTimer(navController)
        }
    }
}
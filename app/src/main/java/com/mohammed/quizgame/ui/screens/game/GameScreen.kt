package com.mohammed.quizgame.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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

    Column(modifier = Modifier.fillMaxSize())
    {

        CurrentScore()

        CurrentQuestion(question = quiz.question, quiz.currentQuestion.toString())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            CurrentQuestionNumber(quiz.currentQuestion, quiz.totalQuestions)
            Timer(quiz.time.toString())

        }

        quiz.answers.forEach {
            AnswerOption(it.values.first())

        }
        LaunchedEffect(quiz.currentQuestion) {
            viewModel.startTimer()
        }
    }
}
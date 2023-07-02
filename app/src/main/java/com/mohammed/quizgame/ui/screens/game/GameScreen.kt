package com.mohammed.quizgame.ui.screens.game

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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

    Column(
        modifier = Modifier.fillMaxSize()

    ) {

        CurrentQuestion("sklfslkdfs")

        Spacer(modifier = Modifier.size(16.dp))


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            CurrentQuestionNumber(2, 5)
            Timer(quiz.time.toString())

        }


        AnswerOption("one")
        AnswerOption("two")
        AnswerOption("three")
        AnswerOption("four")
        Spacer(modifier = Modifier.size(16.dp))
        CurrentScore()

        // Start the countdown timer when the component is first composed
        LaunchedEffect(Unit) {
            val countdownTimer = object : CountDownTimer(60000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    val secondsRemaining = (millisUntilFinished / 1000).toInt()
                    viewModel.updateTimerValue(secondsRemaining)
                }

                override fun onFinish() {
                    viewModel.updateTimerValue(0)
                }
            }
            countdownTimer.start()


        }


    }

}

//@Composable
//@Preview(showSystemUi = true)
//fun previewGameScreen() {
//    val navController = rememberNavController()
//
//
//    GameScreen(navController)
//}
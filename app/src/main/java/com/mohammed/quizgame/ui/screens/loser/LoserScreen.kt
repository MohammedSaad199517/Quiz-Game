package com.mohammed.quizgame.ui.screens.loser

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mohammed.quizgame.composable.LottieGameOver
import com.mohammed.quizgame.composable.PlayAgainButton

@Composable
fun LoserScreen (
    navController: NavController,
    viewModel: LoserViewModel= hiltViewModel()
){
    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)

    ) {
        LottieGameOver()
        Text(
            text = "Game Over",
            fontSize = 32.sp,
            color = Color.Red
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(text = "score achieved : ${uiState.scoreAchieved}")
        Spacer(modifier = Modifier.size(16.dp))
        PlayAgainButton(navController)


    }

}
@Composable
@Preview(showSystemUi = true)
fun PreviewLoserScreen(){
    val navController = rememberNavController()
    LoserScreen (navController)

}
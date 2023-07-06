package com.mohammed.quizgame.composable

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mohammed.quizgame.ui.theme.MainColor

@Composable
fun StartButton(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToGameScreen: (navController: NavController) -> Unit,
    openAlertDialogIfRequireNumberOfQuestionIsNotAvailable: () -> Unit,
    updateNumberOfAvailableQuestion: () -> Unit,
    isLoading: Boolean,

    ) {
    Button(
        enabled = !isLoading,
        modifier = modifier,
        onClick = {

            updateNumberOfAvailableQuestion()
            openAlertDialogIfRequireNumberOfQuestionIsNotAvailable()
            navigateToGameScreen(navController)
        },
        colors = ButtonDefaults.buttonColors(MainColor),

        ) {
        Text(
            text = "Start",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
    }
}
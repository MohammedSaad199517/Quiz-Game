package com.mohammed.quizgame.composable

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.mohammed.quizgame.Screen
import com.mohammed.quizgame.ui.theme.MainColor

@Composable
fun PlayAgainButton(navController: NavController) {
    Button(
        onClick = {
            navController.popBackStack(Screen.ConfigurationScreen.route,false)
        },
        colors = ButtonDefaults.buttonColors(MainColor),

        ) {
        Text(text = "play again")

    }
}
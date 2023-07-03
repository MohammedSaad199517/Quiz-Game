package com.mohammed.quizgame.ui.screens.winner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mohammed.quizgame.ui.theme.MainColor

@Composable
fun WinnerScreen(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)

    ) {
        Text(
            text = "you win",
            fontSize = 32.sp,
            color = Color.Green
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(MainColor),

            ) {
            Text(text = "play again")

        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun PreviewWinnerScreen() {
    val navController = rememberNavController()
    WinnerScreen(navController)
}

package com.mohammed.quizgame.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.navigation.NavController
import com.mohammed.quizgame.Screen

@Composable
fun AlertDialog(open: Boolean?, navController: NavController) {
    val openDialog = remember { mutableStateOf(open) }

    if (openDialog.value == true) {
        AlertDialog(
            onDismissRequest = {  },
            title = { Text(text = "oops") },
            text = { Text(text = " Sorry ,There is just 4 questions in this level of category") },
            confirmButton = {
                TextButton(onClick = {
                    navController.navigate(Screen.GameScreen.route)
                    openDialog.value = false
                }) {
                    Text(text = "continue")

                }
            },
            dismissButton = {
                TextButton(onClick = {
                    openDialog.value = false
                }) {
                    Text(text = "cansel")

                }
            }
        )

    }


}


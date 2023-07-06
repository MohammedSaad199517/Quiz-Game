package com.mohammed.quizgame.composable

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mohammed.quizgame.R
import com.mohammed.quizgame.Screen

@Composable
fun AlertDialog(
    isAlertDialogOpen: Boolean,
    navController: NavController,
    numberOfAvailableQuestion: Int,
    saveConfig: (selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) -> Unit,
    closeAlertDialog: () -> Unit,
    textMessage: (numberOfAvailableQuestion: Int) -> String

) {


    if (isAlertDialogOpen) {
        saveConfig(null, null, numberOfAvailableQuestion)

        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = stringResource(R.string.oops)) },
            text = {
                Text(text = textMessage(numberOfAvailableQuestion))
            },
            confirmButton = {
                if (numberOfAvailableQuestion > 0) {
                    TextButton(onClick = {
                        closeAlertDialog()
                        navController.navigate(Screen.GameScreen.route)

                    }) {
                        Text(text = stringResource(R.string.Continue))
                    }
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    closeAlertDialog()
                }) {
                    Text(text = stringResource(R.string.cansel))
                }
            }
        )
    }
}



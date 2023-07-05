package com.mohammed.quizgame.composable

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun StartButton(
    modifier: Modifier = Modifier,
    navController: NavController,
    navigateToGameScreen: (navController: NavController) -> Unit,
    saveConfig: (selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) -> Unit,
    selectedCategory: String?,
    selectedLevel: String?,
    selectedQuantity: Int?,
    openAlertDialogIfRequireNumberOfQuestionIsNotAvailable: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = {
            saveConfig(
                selectedCategory,
                selectedLevel,
                selectedQuantity
            )
            openAlertDialogIfRequireNumberOfQuestionIsNotAvailable()
            navigateToGameScreen(navController)
        },
    ) {
        Text(text = "Start")
    }
}
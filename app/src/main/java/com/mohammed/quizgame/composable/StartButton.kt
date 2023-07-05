package com.mohammed.quizgame.composable


import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StartButton (
    navController: NavController,
    chickIfNumberOfQuestionIsAvailable:()->Unit,
    navigateToGameScreen:(navController: NavController)->Unit,
    saveConfig:(selectedCategory: String?,selectedLevel: String?,selectedQuantity: Int? )-> Unit,
    selectedCategory: String?,
    selectedLevel: String?,
    selectedQuantity: Int?

){
    Button(
        onClick = {

            saveConfig(
                selectedCategory,
                selectedLevel,
                selectedQuantity
            )

            chickIfNumberOfQuestionIsAvailable()
            navigateToGameScreen(navController)
        },
    ) {
        Text(text = "Start")
    }
}
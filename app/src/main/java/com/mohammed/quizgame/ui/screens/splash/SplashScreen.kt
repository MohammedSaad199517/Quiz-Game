package com.mohammed.quizgame.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mohammed.quizgame.Screen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen (navController: NavController){
    LaunchedEffect(key1 =true  ){
        delay(5000L)
        navController.navigate(Screen.ConfigurationScreen.route)

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Splash screen")
        
    }
}
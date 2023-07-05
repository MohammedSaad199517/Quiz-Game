package com.mohammed.quizgame.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Timer(time:Long ,backgroundColorTimer:(time:Long)->Color) {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(
             backgroundColorTimer(time)
                , CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$time",
            color = Color.White,
            style = TextStyle(textAlign = TextAlign.Center),
            fontSize = 18.sp
        )
    }
}
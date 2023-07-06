package com.mohammed.quizgame.composable

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextSelect(text: String) {
    Text(
        text = text,
        modifier = Modifier,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium

    )
}
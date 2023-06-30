package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.mainColor

@Composable
fun TextSelect(text:String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = mainColor

    )
}
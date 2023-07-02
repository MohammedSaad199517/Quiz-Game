package com.mohammed.quizgame.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.mainColor
import com.mohammed.quizgame.ui.theme.white87

@Composable
fun CurrentScore() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .background(mainColor, RoundedCornerShape(16.dp))
            .padding(8.dp)
    ) {
        Box() {
            Text(
                text = "Score :",
                color = white87,
                fontSize = 16.sp
            )
        }

        Text(
            text = "2",
            color = white87,
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}
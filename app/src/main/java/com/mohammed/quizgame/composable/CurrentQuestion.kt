package com.mohammed.quizgame.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.mainColor
import com.mohammed.quizgame.ui.theme.white87

@Composable
fun CurrentQuestion(question: String) {
    Text(
        text = question,
        modifier = Modifier
            .fillMaxWidth()
            .background(mainColor)
            .padding(horizontal = 10.dp, vertical = 32.dp)
            .height(150.dp),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        color = white87,
        fontWeight = FontWeight.SemiBold

    )
}

@Composable
@Preview(showSystemUi = true)
fun PreviewCurrentQuestion() {
    CurrentQuestion("wwwwwwwwwwwwwwwwwwwwwww")
}
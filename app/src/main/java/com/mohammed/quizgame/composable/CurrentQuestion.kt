package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.MainColor
import com.mohammed.quizgame.ui.theme.White87


@Composable
fun CurrentQuestion(question: String, numberOfQuestion: String) {

    Card(
        colors = CardDefaults.cardColors(MainColor),
        shape = RectangleShape
    ) {
        Text(
            text = "Q$numberOfQuestion : $question",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(150.dp),
            textAlign = TextAlign.Start,
            fontSize = 18.sp,
            color = White87,
            fontWeight = FontWeight.SemiBold

        )
    }

}


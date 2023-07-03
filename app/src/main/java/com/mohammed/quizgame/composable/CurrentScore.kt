package com.mohammed.quizgame.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.Gold87
import com.mohammed.quizgame.ui.theme.MainColor
import com.mohammed.quizgame.ui.theme.White87


@Composable
fun CurrentScore(currentScore:Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(MainColor),
        shape = RectangleShape
    ) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .background(Gold87, RoundedCornerShape(16.dp))
                .padding(8.dp),
            text = "Score : $currentScore",
            color = White87,
            fontSize = 16.sp
        )
    }


}
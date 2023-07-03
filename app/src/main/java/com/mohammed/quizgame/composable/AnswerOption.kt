package com.mohammed.quizgame.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohammed.quizgame.ui.theme.MainColor
import com.mohammed.quizgame.ui.theme.White87

@Composable
fun AnswerOption(answer: String) {


        Button(

            modifier = Modifier
                .fillMaxWidth().
                    background(White87)
                .padding(horizontal = 16.dp, vertical = 4.dp),
            shape = RoundedCornerShape(16.dp),
            onClick = {},
            colors= ButtonDefaults.buttonColors(White87),
            border = BorderStroke(1.dp, MainColor)

    ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = answer,
                color = Color.Black,
                fontSize = 16.sp,
            )
        }

}
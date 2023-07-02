package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun CurrentQuestionNumber(current:Int,total:Int){
    Row(

    ) {
        Text(
            text = current.toString(),
            fontSize = 18.sp,
        )
        Text(
            text = "/${total}",
            fontSize = 18.sp,
        )
    }
}
package com.mohammed.quizgame.composable

import androidx.compose.foundation.BorderStroke
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

@Composable
fun AnswerOption(
    answer: HashMap<String, String>,
    isCorrectAnswer: (answerStatus: String) -> Unit,
    getAnswerSelectedId: (id: Int) -> Unit,
    updateScore: () -> Unit,
    backgroundAnswerOptionButton: (id: Int) -> Color,
    disableButtonWhenAnswerIsSelected: (id: Int) -> Boolean,
    answerId: Int,
) {


    Button(

        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            isCorrectAnswer(answer.keys.first())
            getAnswerSelectedId(answerId)
            updateScore()


        },
        colors = ButtonDefaults.buttonColors(

            backgroundAnswerOptionButton(answerId)


        ),
        border = BorderStroke(1.dp, MainColor),
        enabled = disableButtonWhenAnswerIsSelected(answerId)

    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            text = answer.values.first(),
            color = Color.Black,
            fontSize = 16.sp,
        )
    }

}
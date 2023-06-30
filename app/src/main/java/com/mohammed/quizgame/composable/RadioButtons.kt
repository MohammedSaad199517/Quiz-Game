package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mohammed.quizgame.ui.theme.mainColor

object Level{
    const val EASY = "Easy"
    const val MEDIUM = "Medium"
    const val HARD = "Hard"
}

@Composable
fun Option(selectLevel: MutableState<String>,level:String){
    RadioButton(
        selected = selectLevel.value == level ,
        onClick = { selectLevel.value = level },
        colors = RadioButtonDefaults.colors(mainColor),

    )
//    Spacer(modifier = Modifier.size(16.dp))
    Text(text = level,  modifier = Modifier.padding(0.dp,14.dp))
}
@Composable
fun RadioButtons() {

    val selectLevel = remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        Arrangement.Center
    ) {
        Option(selectLevel,Level.EASY)
        Option(selectLevel,Level.MEDIUM)
        Option(selectLevel,Level.HARD)
    }

}

@Preview(showSystemUi = true)
@Composable
fun previewRadioButtons() {
    RadioButtons()
}


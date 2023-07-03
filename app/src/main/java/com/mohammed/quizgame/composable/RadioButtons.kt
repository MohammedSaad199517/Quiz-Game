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
import androidx.compose.ui.unit.dp
import com.mohammed.quizgame.ui.screens.configuration.ConfigurationViewModel
import com.mohammed.quizgame.ui.theme.MainColor

object Level {
    const val EASY = "easy"
    const val MEDIUM = "medium"
    const val HARD = "hard"
}

@Composable
fun Option(
    selectLevel: MutableState<String>,
    level: String,
    viewModel: ConfigurationViewModel
) {
    RadioButton(
        selected = selectLevel.value == level,
        onClick = {
            selectLevel.value = level
            viewModel.updateSelectedLevel(selectLevel.value)
        },
        colors = RadioButtonDefaults.colors(MainColor),

        )
    Text(text = level, modifier = Modifier.padding(0.dp, 14.dp))
}

@Composable
fun RadioButtons(
    viewModel: ConfigurationViewModel
) {

    val selectLevel = remember { mutableStateOf("") }

    Row(
        modifier = Modifier.fillMaxWidth(),
        Arrangement.Center
    ) {
        Option(selectLevel, Level.EASY,viewModel)
        Option(selectLevel, Level.MEDIUM,viewModel)
        Option(selectLevel, Level.HARD,viewModel)
    }

}



package com.mohammed.quizgame.ui.screens.configuration

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mohammed.quizgame.R
import com.mohammed.quizgame.composable.ExposedDropdownMenuBox
import com.mohammed.quizgame.composable.RadioButtons
import com.mohammed.quizgame.composable.TextSelect


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConfigurationScreen(
    navController: NavController,
    viewModel: ConfigurationViewModel = hiltViewModel()
) {
//    val optionsNumbers = listOf("1", "2", "3", "4", "5")
    val questions by viewModel.uiState.collectAsState()





    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_category))

        Spacer(modifier = Modifier.height(8.dp))
        ExposedDropdownMenuBox(
            options = questions.categories,
            width = 250.dp,
            viewModel
        )

        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_difficult_level))

        Spacer(modifier = Modifier.height(8.dp))
        RadioButtons(viewModel)

        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_quantity))

//        ExposedDropdownMenuBox(options = optionsNumbers)
        Spacer(modifier = Modifier.height(32.dp))
        Button(

            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {
            },

            ) {
            Text(text = "Start")
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewConfigurationScreen() {
    val navController = rememberNavController()
    ConfigurationScreen(
        navController

    )
}

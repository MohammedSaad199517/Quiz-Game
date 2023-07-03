package com.mohammed.quizgame.ui.screens.configuration

import android.annotation.SuppressLint
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mohammed.quizgame.R
import com.mohammed.quizgame.composable.AlertDialog
import com.mohammed.quizgame.composable.DropdownCategoryMenuBox
import com.mohammed.quizgame.composable.DropdownQuestionQuantityMenu
import com.mohammed.quizgame.composable.RadioButtons
import com.mohammed.quizgame.composable.TextSelect

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConfigurationScreen(
    navController: NavController,
    viewModel: ConfigurationViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()





    Column(
        modifier = Modifier.fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_category))

        Spacer(modifier = Modifier.height(8.dp))
        DropdownCategoryMenuBox(
            options = uiState.categories,
            viewModel
        )

        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_difficult_level))

        Spacer(modifier = Modifier.height(8.dp))
        RadioButtons(viewModel)

        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_quantity))

        DropdownQuestionQuantityMenu(viewModel = viewModel)
        Spacer(modifier = Modifier.height(32.dp))
        Button(

            modifier = Modifier.align(Alignment.CenterHorizontally),
            onClick = {

                viewModel.saveConfig(
                    uiState.selectedCategory,
                    uiState.selectedLevel,
                    uiState.selectedQuantity
                )

                viewModel.chickIfNumberOfQuestionIsAvailable()
                viewModel.navigateToGameScreen(navController)
            },
            ) {
            Text(text = "Start")
        }

        AlertDialog(
            uiState.isNumberOfQuestionAvailable,
            navController
        )
    }
}





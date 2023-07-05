package com.mohammed.quizgame.ui.screens.configuration

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.mohammed.quizgame.composable.StartButton
import com.mohammed.quizgame.composable.TextSelect

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ConfigurationScreen(
    navController: NavController,
    viewModel: ConfigurationViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()

    ConfigurationContent(
        categories = uiState.categories,
        updateSelectedCategory = viewModel::updateSelectedCategory,
        isLoading = uiState.isLoading,
        updateSelectedLevel = viewModel::updateSelectedLevel,
        updateSelectedQuantity = viewModel::updateSelectedQuantity,
        navController = navController,
        chickIfNumberOfQuestionIsAvailable = viewModel::chickIfNumberOfQuestionIsAvailable,
        navigateToGameScreen = viewModel::navigateToGameScreen,
        saveConfig = viewModel::saveConfig,
        selectedCategory = uiState.selectedCategory,
        selectedLevel = uiState.selectedLevel,
        selectedQuantity = uiState.selectedQuantity,
        isNumberOfQuestionAvailable = uiState.isNumberOfQuestionAvailable,
    )
}

@Composable
private fun ConfigurationContent(
    categories: List<String>,
    updateSelectedCategory: (selectedOption: String) -> Unit,
    isLoading: Boolean,
    updateSelectedLevel: (value: String) -> Unit,
    updateSelectedQuantity: (value: Int) -> Unit,
    navController: NavController,
    chickIfNumberOfQuestionIsAvailable: () -> Unit,
    navigateToGameScreen: (navController: NavController) -> Unit,
    saveConfig: (selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) -> Unit,
    selectedCategory: String?,
    selectedLevel: String?,
    selectedQuantity: Int?,
    isNumberOfQuestionAvailable: Boolean?


) {
    Column(
        modifier = Modifier.fillMaxSize()


    ) {
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_category))

        Spacer(modifier = Modifier.height(8.dp))
        DropdownCategoryMenuBox(
            options = categories,
            updateSelectedCategory = updateSelectedCategory,
            isLoading = isLoading

        )
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_difficult_level))
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtons(updateSelectedLevel)
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_quantity))

        DropdownQuestionQuantityMenu(updateSelectedQuantity)
        Spacer(modifier = Modifier.height(32.dp))
        StartButton(
            navController,
            chickIfNumberOfQuestionIsAvailable,
            navigateToGameScreen,
            saveConfig,
            selectedCategory,
            selectedLevel,
            selectedQuantity
        )

        AlertDialog(
            isNumberOfQuestionAvailable,
            navController
        )
    }

}



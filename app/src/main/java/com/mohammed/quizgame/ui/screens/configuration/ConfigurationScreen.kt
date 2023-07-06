package com.mohammed.quizgame.ui.screens.configuration

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
        navigateToGameScreen = viewModel::navigateToGameScreen,
        saveConfig = viewModel::saveConfig,
        numberOfAvailableQuestion = uiState.numberOfAvailableQuestion,
        updateNumberOfAvailableQuestion = viewModel::updateNumberOfAvailableQuestion,
        openAlertDialogIfRequireNumberOfQuestionIsNotAvailable = viewModel::openAlertDialogIfRequireNumberOfQuestionIsNotAvailable,
        isAlertDialogOpen = uiState.isAlertDialogOpen,
        closeAlertDialog = viewModel::closeAlertDialog,
        textMessage = viewModel::textMessage
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
    navigateToGameScreen: (navController: NavController) -> Unit,
    saveConfig: (selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) -> Unit,
    numberOfAvailableQuestion: Int,
    updateNumberOfAvailableQuestion: () -> Unit,
    openAlertDialogIfRequireNumberOfQuestionIsNotAvailable: () -> Unit,
    isAlertDialogOpen: Boolean,
    closeAlertDialog: () -> Unit,
    textMessage: (numberOfAvailableQuestion: Int) -> String

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_question_category))

        Spacer(modifier = Modifier.height(8.dp))
        DropdownCategoryMenuBox(
            options = categories,
            updateSelectedCategory = updateSelectedCategory,
            isLoading = isLoading,
            saveConfig = saveConfig

        )
        Spacer(modifier = Modifier.height(32.dp))
        TextSelect(text = stringResource(R.string.select_difficult_level))
        Spacer(modifier = Modifier.height(8.dp))
        RadioButtons(updateSelectedLevel, saveConfig)
        Spacer(modifier = Modifier.height(32.dp))
        Row(

        ) {
            TextSelect(text = stringResource(R.string.select_question_quantity))
            DropdownQuestionQuantityMenu(
                updateSelectedQuantity = updateSelectedQuantity,
                saveConfig = saveConfig,

                )
        }

        Spacer(modifier = Modifier.height(32.dp))
        StartButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp),
            navController = navController,
            navigateToGameScreen = navigateToGameScreen,
            openAlertDialogIfRequireNumberOfQuestionIsNotAvailable = openAlertDialogIfRequireNumberOfQuestionIsNotAvailable,
            updateNumberOfAvailableQuestion = updateNumberOfAvailableQuestion,
            isLoading = isLoading

        )

        AlertDialog(
            isAlertDialogOpen = isAlertDialogOpen,
            navController = navController,
            numberOfAvailableQuestion = numberOfAvailableQuestion,
            saveConfig = saveConfig,
            closeAlertDialog = closeAlertDialog,
            textMessage = textMessage
        )
    }
}


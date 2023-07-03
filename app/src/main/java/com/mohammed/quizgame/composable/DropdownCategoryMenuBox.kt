package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mohammed.quizgame.ui.screens.configuration.ConfigurationViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownCategoryMenuBox(
    options: List<String>,
    viewModel: ConfigurationViewModel

) {
    val isLoading by viewModel.uiState.collectAsState()

    if (!isLoading.isLoading) {
        var expandedState by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf(options[0]) }


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center

        )
        {
            ExposedDropdownMenuBox(
                modifier = Modifier.width(250.dp),
                expanded = expandedState,
                onExpandedChange = { expandedState = !expandedState }
            )
            {
                TextField(
                    value = selectedOption,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedState)
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(),
                    modifier = Modifier.menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = expandedState,
                    onDismissRequest = { expandedState = false }
                ) {

                    options.forEach { selectedText ->
                        DropdownMenuItem(
                            text = { Text(text = selectedText) },
                            onClick = {
                                selectedOption = selectedText
                                expandedState = false
                                viewModel.updateSelectedCategory(selectedOption)
                            })
                    }
                }
            }
        }
    }else{
        ProgressBar()
    }

}


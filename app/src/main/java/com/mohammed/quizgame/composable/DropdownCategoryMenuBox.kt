package com.mohammed.quizgame.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.mohammed.quizgame.ui.theme.MainColor
import com.mohammed.quizgame.ui.theme.White87

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownCategoryMenuBox(
    options: List<String>,
    updateSelectedCategory: (selectedOption: String) -> Unit,
    isLoading: Boolean,
    saveConfig: (selectedCategory: String?, selectedLevel: String?, selectedQuantity: Int?) -> Unit,
    ) {

    if (!isLoading) {
        var expandedState by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf(options[0]) }
        updateSelectedCategory(selectedOption)
        saveConfig(selectedOption, null, null)

        val iconColor: ImageVector = if (expandedState) {
            Icons.Default.KeyboardArrowUp
        } else {
            Icons.Default.ArrowDropDown
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center

        )
        {
            ExposedDropdownMenuBox(
                modifier = Modifier.fillMaxWidth(),
                expanded = expandedState,
                onExpandedChange = { expandedState = !expandedState }
            )
            {
                TextField(
                    value = selectedOption,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = {

                        Icon(
                            iconColor,
                            contentDescription = null,
                            tint = White87
                        )
                    },
                    colors = ExposedDropdownMenuDefaults.textFieldColors(
                        containerColor = MainColor,
                        textColor = White87
                    ),
                    modifier = Modifier
                        .menuAnchor()
                        .height(56.dp)
                        .width(300.dp)
                )

                ExposedDropdownMenu(
                    expanded = expandedState,
                    onDismissRequest = { expandedState = false },
                    modifier = Modifier
                ) {

                    options.forEach { selectedText ->
                        DropdownMenuItem(
                            text = { Text(text = selectedText) },
                            onClick = {
                                selectedOption = selectedText
                                expandedState = false
                                updateSelectedCategory(selectedOption)
                                saveConfig(selectedOption, null, null)

                            },
                            modifier = Modifier.drawBehind {
                                drawLine(
                                    color = MainColor,
                                    start = Offset(0f, size.height),
                                    end = Offset(size.width, size.height),
                                    strokeWidth = 1f
                                )
                            }
                        )
                    }
                }
            }
        }
    } else {
        ProgressBar()
    }

}



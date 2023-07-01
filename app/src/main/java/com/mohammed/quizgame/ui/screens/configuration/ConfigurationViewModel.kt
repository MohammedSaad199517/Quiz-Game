package com.mohammed.quizgame.ui.screens.configuration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohammed.quizgame.domain.usecase.GetAllQuestionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfigurationViewModel @Inject constructor(
    private val getAllQuestionsUseCase: GetAllQuestionsUseCase
) :ViewModel() {
    private val _uiState = MutableStateFlow(ConfigurationUISate())
    val uiState:StateFlow<ConfigurationUISate> =_uiState
    init {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update {
                it.copy(
                    isLoading = false,
                    response = getAllQuestionsUseCase.invoke()
                )
            }
        }
    }


}
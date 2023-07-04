package com.mohammed.quizgame.ui.screens.winner

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class WinnerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle

) :ViewModel() {
    private val _uiState = MutableStateFlow(WinnerUIState())
    val uiState = _uiState.asStateFlow()
    private val args:String = checkNotNull(savedStateHandle["score"])
    init {
        _uiState.update { it.copy(scoreAchieved = args) }
    }
}
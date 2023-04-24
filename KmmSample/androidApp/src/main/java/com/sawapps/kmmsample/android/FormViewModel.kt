package com.sawapps.kmmsample.android

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.sawapps.kmmsample.UserRepository

data class FormViewState(
    val text: String = "",
    val isSaveEnabled: Boolean = false
) {
    companion object {
        val Empty = FormViewState()
    }
}

class FormViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _viewState = mutableStateOf(FormViewState())
    val viewState: State<FormViewState> = _viewState

    init {
        onTextChanged(userRepository.userName)
    }

    fun onTextChanged(text: String) {
        _viewState.value = _viewState.value.copy(
            text = text,
            isSaveEnabled = text.isNotEmpty()
        )
    }

    fun onSaveClick() {
        userRepository.userName = _viewState.value.text
        _viewState.value = FormViewState.Empty
    }
}
package com.example.tripparcel.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _homeText = MutableStateFlow("Hello World")
    var homeText: StateFlow<String> = _homeText

    fun updateHomeText(newText: String) {
        _homeText.value = newText
    }
}
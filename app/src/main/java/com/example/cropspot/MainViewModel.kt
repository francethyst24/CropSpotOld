package com.example.cropspot

import androidx.lifecycle.ViewModel
import com.example.cropspot.ui.crop_list.CropListEvent
import com.example.cropspot.utils.Screen
import com.example.cropspot.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onCropListEvent(event: CropListEvent) {
        when (event) {
            is CropListEvent.OnCropClick -> {
                _uiEvent.tryEmit(UiEvent.Navigate(Screen.CropScreen.route))
            }
        }
    }

    fun onMainActivityEvent(event: MainActivityEvent) {

    }

}
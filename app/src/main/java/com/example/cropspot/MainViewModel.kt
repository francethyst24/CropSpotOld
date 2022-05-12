package com.example.cropspot

import androidx.lifecycle.ViewModel
import com.example.cropspot.data.CropRepository
import com.example.cropspot.ui.crop_list.CropListEvent
import com.example.cropspot.utils.Destination
import com.example.cropspot.utils.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    cropRepository: CropRepository,
) : ViewModel() {
    val cropList by lazy { cropRepository.loadAllCrops }

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onCropListEvent(event: CropListEvent) {
        when (event) {
            is CropListEvent.OnCropClick -> {
                _uiEvent.tryEmit(UiEvent.Navigate(Destination.Crop.route))
            }
        }
    }

    fun onMainActivityEvent(event: MainActivityEvent) {
        when (event) {
            else -> {

            }
        }
    }

}
package com.example.cropspot.ui.crop_list

sealed class CropListEvent {
    data class OnCropClick(val crop: String): CropListEvent()
}

package com.example.cropspot.ui.crop_list

import com.example.cropspot.data.Crop

sealed class CropListEvent {
    data class OnCropClick(val crop: Crop): CropListEvent()
}

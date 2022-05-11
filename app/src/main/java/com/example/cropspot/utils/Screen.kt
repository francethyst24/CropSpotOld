package com.example.cropspot.utils

sealed class Screen(val route: String) {
    object MainScreen: Screen("main")
    object CropScreen: Screen("crop")
}

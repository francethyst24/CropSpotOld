package com.example.cropspot.ui.screen

sealed class Screen(val route: String) {
    object MainScreen: Screen("main")
    object CropScreen: Screen("crop")
}

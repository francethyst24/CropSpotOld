package com.example.cropspot.ui.main

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cropspot.R
import com.example.cropspot.ui.crop_list.CropList
import com.example.cropspot.ui.crop_profile.CropScreen
import com.example.cropspot.utils.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavHostController,
    scope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState,
) {
    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            MainSheetContentList()
        },
        content = {
            MainScaffold(navController, scope, bottomSheetState)
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    scope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState
) {
    Scaffold(
        topBar = {
            MainTopAppBar()
        },
        floatingActionButton = {
            MainFloatingActionButton(scope, bottomSheetState)
        },
        content = {
            MainNavHost(navController)
        },
    )
}

@Composable
fun MainTopAppBar() {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        actions = {
            IconButton(
                onClick = {
                    /*TODO*/
                },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Search,
                        contentDescription = "Search",
                    )
                }
            )
            IconButton(
                onClick = {
                    /*TODO*/
                },
                content = {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "Settings",
                    )
                }
            )
        },
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainFloatingActionButton(scope: CoroutineScope, bottomSheetState: ModalBottomSheetState) {
    FloatingActionButton(
        onClick = {
            scope.launch {
                bottomSheetState.show()
            }
        },
        content = {
            Icon(
                painter = painterResource(id = R.drawable.ic_image_search),
                contentDescription = "Diagnose"
            )
        },
    )
}

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destination.Home.route
    ) {
        composable(Destination.Home.route) {
            CropList()
        }
        composable(Destination.Crop.route) {
            CropScreen()
        }
    }
}
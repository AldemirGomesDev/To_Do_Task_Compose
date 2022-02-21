package com.aldemir.to_do_compose.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.aldemir.to_do_compose.navigation.destinations.listComposable
import com.aldemir.to_do_compose.navigation.destinations.splashComposable
import com.aldemir.to_do_compose.navigation.destinations.taskComposable
import com.aldemir.to_do_compose.ui.viewmodels.SharedViewModel
import com.aldemir.to_do_compose.util.Constants.LIST_SCREEN
import com.aldemir.to_do_compose.util.Constants.SPLASH_SCREEN

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
)
{
    val screen = remember(navController) {
        Screens(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = SPLASH_SCREEN)
    {
        splashComposable(
            navigateToListScreen = screen.splash
        )
        listComposable(
            navigateToTaskScreen = screen.list,
            sharedViewModel = sharedViewModel
        )
        taskComposable(
            sharedViewModel = sharedViewModel,
            navigateToListScreen = screen.task
        )
    }
}
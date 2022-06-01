package com.aldemir.to_do_compose.navigation.destinations


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.google.accompanist.navigation.animation.composable
import com.aldemir.to_do_compose.ui.screens.splash.SplashScreen
import com.aldemir.to_do_compose.util.Constants


@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToListScreen: () -> Unit,
) {
    composable(
        route = Constants.SPLASH_SCREEN,
        exitTransition = { _, _ ->
            slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 1000)
            )
        }
    ) {
        SplashScreen(navigateToListScreen = navigateToListScreen)
    }
}
package br.com.alura.panucci.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.navOptions
import br.com.alura.panucci.ui.components.BottomAppBarItem

@Composable
fun PanucciNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = highlightListRoute
    ) {
        highlightGraphListScreen(navController)
        menuScreen(navController)
        drinksScreen(navController)
        productDetailsScreen(navController)
        checkoutScreen(navController)
    }
}

fun NavController.navigateSingleTopWithPopTo(
    item: BottomAppBarItem,
) {
    val (route, navigate) = when (item) {
        BottomAppBarItem.Drinks -> Pair(
            drinksRoute,
            ::navigateToDrinks
        )

        BottomAppBarItem.HighlightsList -> Pair(
            highlightListRoute,
            ::navigateToHighlight
        )

        BottomAppBarItem.Menu -> Pair(
            menuRoute,
            ::navigateToMenu
        )
    }

    val navOptions = navOptions {
        launchSingleTop = true
        popUpTo(route)
    }
    navigate(navOptions)
}

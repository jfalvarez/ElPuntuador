package com.jfaf.elpuntuador.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jfaf.elpuntuador.ui.screens.choice.ChoiceView
import com.jfaf.elpuntuador.ui.screens.main.ElPuntuadorApp
import com.jfaf.elpuntuador.ui.screens.newgame.NewGameView

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavItem.Choice.route
    ) {
        composable(NavItem.Choice) {
            ChoiceView(
                onUpClick = { navController.popBackStack() },
                onNewGameClick = { navController.navigate(NavItem.CreateGame.route) },
                onLoadGameClick = { navController.navigate(NavItem.SelectGame.route) }
            )
        }
        composable(NavItem.CreateGame){
            NewGameView(
                onUpClick = { navController.popBackStack(NavItem.Choice.route, inclusive = false) },
                onStartClicked = {
                    navController.popBackStack(NavItem.Choice.route, inclusive = false)
                    navController.navigate(NavItem.Main.route)
                }
            )
        }
        composable(NavItem.Main) {
            ElPuntuadorApp(onUpClick = { navController.popBackStack() })
        }
        composable(NavItem.SelectGame) {
            ElPuntuadorApp(onUpClick = { navController.popBackStack() })
        }
    }
}

private fun NavGraphBuilder.composable(
    navItem: NavItem,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(route = navItem.route, arguments = navItem.args) {
        content(it)
    }
}

private inline fun <reified T> NavBackStackEntry.findArg(key: String): T {
    val value = arguments?.get(key)
    requireNotNull(value)
    return value as T
}
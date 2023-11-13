package com.jfaf.elpuntuador.ui.screens.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jfaf.elpuntuador.ui.screens.choice.ChoiceView
import com.jfaf.elpuntuador.ui.screens.main.ElPuntuadorApp

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavItem.Choice.route
    ) {
        composable(NavItem.Choice) {
            ChoiceView(
                { navController.navigate(NavItem.Main.route) },
                {}
            )
        }
        composable(NavItem.Main) {
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
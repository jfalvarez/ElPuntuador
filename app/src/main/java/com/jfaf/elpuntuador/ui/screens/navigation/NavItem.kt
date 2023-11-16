package com.jfaf.elpuntuador.ui.screens.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    val baseRoute: String,
    val navArgs: List<NavArg> = emptyList()
) {

    val route = run {
        val argskey = navArgs.map {
            "{${it.key}"
        }
        listOf(baseRoute).plus(argskey).joinToString("/")
    }
    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

    object Main : NavItem("main")
    object Choice : NavItem("choice")
    object CreateGame : NavItem("create")
    object SelectGame : NavItem("select")
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    GameID("gameID", NavType.IntType)
}

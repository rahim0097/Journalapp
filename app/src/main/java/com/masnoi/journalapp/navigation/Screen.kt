package com.masnoi.journalapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEdit : Screen("add_edit?entryId={entryId}") {
        fun createRoute(entryId: Int? = null) = "add_edit?entryId=$entryId"
    }
    object Detail : Screen("detail/{entryId}") {
        fun createRoute(entryId: Int) = "detail/$entryId"
    }
    object About : Screen("about")
}

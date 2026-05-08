package com.masnoi.journalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.masnoi.journalapp.navigation.Screen
import com.masnoi.journalapp.ui.screens.AboutScreen
import com.masnoi.journalapp.ui.screens.AddEditScreen
import com.masnoi.journalapp.ui.screens.DetailScreen
import com.masnoi.journalapp.ui.screens.HomeScreen
import com.masnoi.journalapp.ui.theme.JournalAppTheme
import com.masnoi.journalapp.viewmodel.JournalViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JournalAppTheme {
                EchoApp()
            }
        }
    }
}

@Composable
fun EchoApp() {
    val navController = rememberNavController()
    val viewModel: JournalViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(
            route = Screen.Home.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            HomeScreen(
                viewModel = viewModel,
                onAddEntry = {
                    navController.navigate(Screen.AddEdit.createRoute())
                },
                onEntryClick = { entryId ->
                    navController.navigate(Screen.Detail.createRoute(entryId))
                },
                onAboutClick = {
                    navController.navigate(Screen.About.route)
                }
            )
        }

        composable(
            route = Screen.AddEdit.route,
            arguments = listOf(
                navArgument("entryId") {
                    type = NavType.IntType
                    defaultValue = -1
                }
            ),
            enterTransition = { slideInVertically { it } + fadeIn() },
            exitTransition = { slideOutVertically { it } + fadeOut() }
        ) { backStackEntry ->
            val entryId = backStackEntry.arguments?.getInt("entryId")?.takeIf { it != -1 }
            AddEditScreen(
                viewModel = viewModel,
                entryId = entryId,
                onNavigateBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("entryId") { type = NavType.IntType }
            ),
            enterTransition = { slideInHorizontally { it } + fadeIn() },
            exitTransition = { slideOutHorizontally { it } + fadeOut() }
        ) { backStackEntry ->
            val entryId = backStackEntry.arguments?.getInt("entryId") ?: return@composable
            DetailScreen(
                viewModel = viewModel,
                entryId = entryId,
                onNavigateBack = { navController.popBackStack() },
                onEditClick = { id ->
                    navController.navigate(Screen.AddEdit.createRoute(id))
                }
            )
        }

        composable(
            route = Screen.About.route,
            enterTransition = { fadeIn() },
            exitTransition = { fadeOut() }
        ) {
            AboutScreen(onNavigateBack = { navController.popBackStack() })
        }
    }
}

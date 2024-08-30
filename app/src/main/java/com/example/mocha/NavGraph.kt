package com.example.mocha

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mocha.MainActivity.Companion.todoDatabase
import com.example.mocha.screens.AddTodoScreen
import com.example.mocha.screens.CalenderScreen
import com.example.mocha.screens.GoalsScreen
import com.example.mocha.screens.SplashScreen
import com.example.mocha.screens.TodoListPage
import np.com.bimalkafle.todoapp.TodoViewModel

@Composable
fun NavGraph(navController: NavHostController,onSplashFinished: () -> Unit) {
    NavHost(navController = navController, startDestination = "splashScreen") {
        composable(route = BottomBarScreen.home.route) {
            TodoListPage(TodoViewModel(), navController = navController)
        }
        composable(route = BottomBarScreen.calender.route) {
            CalenderScreen()
        }
        composable(route = BottomBarScreen.goals.route) {
            GoalsScreen()
        }

        composable(route = "addTodo") {
            AddTodoScreen(TodoViewModel(), navController = navController)
        }

        composable(route = "splashScreen"){
            SplashScreen(navController= navController, onSplashFinished = onSplashFinished)
        }

        }
    }




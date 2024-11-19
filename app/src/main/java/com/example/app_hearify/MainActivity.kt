package com.example.app_hearify

import com.example.app_hearify.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_hearify.ui.theme.App_HearifyTheme
import com.example.app_hearify.userView.DashboardScreen
import com.example.app_hearify.loginUI.LoginConstraint

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginConstraint(navController, logo = R.drawable.ic_launcher_foreground) }
        composable("dashboard") { DashboardScreen() }
    }
}
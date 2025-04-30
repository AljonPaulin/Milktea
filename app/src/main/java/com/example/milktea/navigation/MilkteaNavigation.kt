package com.example.milktea.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.milktea.pages.Homepage
import com.example.milktea.pages.TeaPage
import com.example.milktea.pages.WelcomePage

@Composable
fun MilkteaNavigation(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "welcome", builder = {
        composable(route = "welcome"){
            WelcomePage(modifier, navController)
        }
        composable(route = "home"){
            Homepage(modifier, navController)
        }
        composable(route = "tea_page"){
            TeaPage(modifier, navController)
        }
    })
}



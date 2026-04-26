package com.example.androidnabigationsampleproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidnabigationsampleproject.ui.theme.AndroidNabigationSampleProjectTheme
import com.example.androidnabigationsampleproject.screens.FirstScreen
import com.example.androidnabigationsampleproject.screens.SecondScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidNabigationSampleProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "firstScreen", modifier = modifier) {
        composable(route = "firstScreen") {
            FirstScreen { name ->
                navController.navigate(route = "secondScreen/$name")
            }
        }
        composable(route = "secondScreen/{name}") {
            val name = it.arguments?.getString("name") ?: "no name"
            SecondScreen(name) {
                navController.navigate(route = "firstScreen")
            }
        }
    }
}
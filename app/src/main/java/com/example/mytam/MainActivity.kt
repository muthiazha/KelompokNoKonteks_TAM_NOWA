package com.example.kelompok_nokonteks_tam_nowa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kelompok_nokonteks_tam_nowa.component.AddTransactionBottomSheet
import com.example.kelompok_nokonteks_tam_nowa.component.BottomNavigationBar
import com.example.kelompok_nokonteks_tam_nowa.screens.*
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.DarkBlue
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.KelompokNoKonteks_TAM_NOWATheme
import com.example.kelompok_nokonteks_tam_nowa.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KelompokNoKonteks_TAM_NOWATheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var showAddTransaction by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (currentRoute != "splash" && currentRoute != "login" && currentRoute != "register" && currentRoute != "profile" && currentRoute != "accounts" && currentRoute != "account_detail") {
                BottomNavigationBar(navController)
            }
        },
        floatingActionButton = {
            if (currentRoute == "home" || currentRoute == "history") {
                FloatingActionButton(
                    onClick = { showAddTransaction = true },
                    containerColor = DarkBlue,
                    contentColor = White,
                    shape = CircleShape,
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("splash") { SplashScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("register") { RegisterScreen(navController) }
            composable("home") { HomeScreen(navController) }
            composable("history") { HistoryScreen() }
            composable("goals") { GoalsScreen() }
            composable("accounts") { AccountsScreen(navController) }
            composable("account_detail") { AccountDetailScreen(navController) }
            composable("profile") { ProfileScreen(navController) }
        }

        if (showAddTransaction) {
            AddTransactionBottomSheet(onDismiss = { showAddTransaction = false })
        }
    }
}

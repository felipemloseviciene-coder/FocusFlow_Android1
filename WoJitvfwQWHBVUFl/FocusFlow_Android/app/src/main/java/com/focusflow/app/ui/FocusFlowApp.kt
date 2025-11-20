package com.focusflow.app.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.focusflow.app.R
import com.focusflow.app.ui.screens.HomeScreen
import com.focusflow.app.ui.screens.SettingsScreen

@Composable
fun FocusFlowApp() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF1A1A1A),
                contentColor = Color.White
            ) {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Configurações") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
            }
        },
        floatingActionButton = {
            if (selectedTab == 0) {
                FloatingActionButton(
                    onClick = { /* TODO: Navegar para tela de criar sessão */ },
                    containerColor = Color(0xFF1F88E5),
                    contentColor = Color.White
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Adicionar")
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.Black)
        ) {
            when (selectedTab) {
                0 -> HomeScreen()
                1 -> SettingsScreen()
            }
        }
    }
}

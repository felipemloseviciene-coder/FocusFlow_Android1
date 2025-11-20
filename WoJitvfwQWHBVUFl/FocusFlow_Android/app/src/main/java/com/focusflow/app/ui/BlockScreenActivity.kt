package com.focusflow.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.focusflow.app.ui.theme.FocusFlowTheme

class BlockScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val sessionName = intent.getStringExtra("sessionName") ?: "Foco Ativo"
        
        setContent {
            FocusFlowTheme {
                BlockScreen(
                    sessionName = sessionName,
                    onSkip = { finish() },
                    onDefer = { finish() }
                )
            }
        }
    }
}

@Composable
fun BlockScreen(
    sessionName: String,
    onSkip: () -> Unit,
    onDefer: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🎯",
            fontSize = 64.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        
        Text(
            text = "Foco Ativo",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        
        Text(
            text = sessionName,
            fontSize = 18.sp,
            color = Color(0xFFB0B0B0),
            modifier = Modifier.padding(bottom = 32.dp)
        )
        
        Text(
            text = "Este app está bloqueado durante seu período de foco",
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(bottom = 32.dp),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )
        
        Button(
            onClick = onDefer,
            modifier = Modifier.padding(bottom = 12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1F88E5),
                contentColor = Color.White
            )
        ) {
            Text("Adiar 5 minutos", fontSize = 16.sp)
        }
        
        Button(
            onClick = onSkip,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4A4A4A),
                contentColor = Color.White
            )
        ) {
            Text("Pular", fontSize = 16.sp)
        }
    }
}

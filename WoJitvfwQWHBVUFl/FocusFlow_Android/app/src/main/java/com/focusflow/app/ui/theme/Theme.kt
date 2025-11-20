package com.focusflow.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1F88E5),
    onPrimary = Color.White,
    primaryContainer = Color(0xFF0D47A1),
    onPrimaryContainer = Color.White,
    secondary = Color(0xFF00BCD4),
    onSecondary = Color.Black,
    secondaryContainer = Color(0xFF004D5C),
    onSecondaryContainer = Color.White,
    tertiary = Color(0xFF7B68EE),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFF5A4BA3),
    onTertiaryContainer = Color.White,
    error = Color(0xFFFF6B6B),
    onError = Color.White,
    errorContainer = Color(0xFF8B0000),
    onErrorContainer = Color.White,
    background = Color(0xFF000000),
    onBackground = Color.White,
    surface = Color(0xFF1A1A1A),
    onSurface = Color.White,
    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = Color(0xFFB0B0B0),
    outline = Color(0xFF4A4A4A),
    outlineVariant = Color(0xFF3A3A3A),
    scrim = Color.Black
)

@Composable
fun FocusFlowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = DarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

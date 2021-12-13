package com.axiaworks.jetpack_compose_sample

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ComposeTutorialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (darkTheme) DarkColors else LightColors,
        content = content
    )
}

private val Yellow200 = Color(0xffffeb46)
private val Blue200 = Color(0xff91a4fc)
private val Yellow400 = Color(0xffffee58)
private val Yellow500 = Color(0xffffeb3b)
private val Blue700 = Color(0xff1976d2)
private val DarkColors = darkColors(
    primary = Yellow200,
    secondary = Blue200,
)
private val LightColors = lightColors(
    primary = Yellow500,
    primaryVariant = Yellow400,
    secondary = Blue700,
)
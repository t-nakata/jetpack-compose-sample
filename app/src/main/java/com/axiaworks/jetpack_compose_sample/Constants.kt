package com.axiaworks.jetpack_compose_sample

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

object Constants {

    val Yellow200 = Color(0xffffeb46)
    val Blue200 = Color(0xff91a4fc)
    val Yellow400 = Color(0xffffee58)
    val Yellow500 = Color(0xffffeb3b)
    val Blue700 = Color(0xff1976d2)
    val DarkColors = darkColors(
        primary = Yellow200,
        secondary = Blue200,
    )
    val LightColors = lightColors(
        primary = Yellow500,
        primaryVariant = Yellow400,
        secondary = Blue700,
    )
}
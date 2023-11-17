package com.kotlincrew.freebies.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.kotlincrew.freebies.R

val freebiesTitleFamily = FontFamily(
    Font(R.font.koulenregular)
)

val freebiesBodyFamily = FontFamily(
    Font(R.font.josefinsansregular)
)

val Typography = Typography(
    //texto grande
    bodyLarge = TextStyle(
        fontFamily = freebiesBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    //texto normal
    bodyMedium = TextStyle(
        fontFamily = freebiesBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    //texto pequeño
    bodySmall = TextStyle(
        fontFamily = freebiesBodyFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    ),
    //para los titulos grandes
    titleMedium = TextStyle(
        fontFamily = freebiesTitleFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp
    ),
    //para los subtitulos
    titleSmall = TextStyle(
        fontFamily = freebiesTitleFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )
)
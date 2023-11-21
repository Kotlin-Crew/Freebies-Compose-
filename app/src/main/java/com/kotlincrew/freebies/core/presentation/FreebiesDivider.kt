package com.kotlincrew.freebies.core.presentation

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun FreebiesDivider() {
    Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
}
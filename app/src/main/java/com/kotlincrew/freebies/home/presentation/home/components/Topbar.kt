package com.kotlincrew.freebies.home.presentation.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.kotlincrew.freebies.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Topbar(
    onMenuclick: () -> Unit
) {
    TopAppBar(title = {
        Text(text = "FREEBIES")
    }, navigationIcon = {
        IconButton(onClick = { onMenuclick() }) {
            Icon(
                painter = painterResource(id = R.drawable.menu_freebies_hamburguer),
                contentDescription = "Button Menu",
                tint = MaterialTheme.colorScheme.secondary
            )

        }
    })
}
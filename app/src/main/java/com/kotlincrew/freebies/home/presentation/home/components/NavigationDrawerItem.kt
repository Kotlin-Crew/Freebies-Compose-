package com.kotlincrew.freebies.home.presentation.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.VideogameAsset
import androidx.compose.ui.graphics.vector.ImageVector


//Esta clase tendria que llamarla para pintar directamente los Items,
//pero no consegui que lo hiciera, asi que por ahora para que puedan,
// pasar la navegacion de cada Item les
enum class NavigationDrawerItem(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val title: String,
){
    ABOUT(Icons.Filled.VideogameAsset,Icons.Outlined.VideogameAsset, "GAMES"),
    SETTINGS(Icons.Filled.CardGiftcard,Icons.Outlined.CardGiftcard, "GIVEAWAYS"),
    RECENT(Icons.Filled.CardGiftcard,Icons.Outlined.CardGiftcard, "FAVORITES"),
    UPLOADS(Icons.Filled.Info,Icons.Outlined.Info, "ABOUT"),

}





/*

val items = listOf(
    NavigationItem(
        title = "GAMES",
        selectedIcon = Icons.Filled.VideogameAsset,
        unselectedIcon = Icons.Outlined.VideogameAsset,
    ),
    NavigationItem(
        title = "GIVEAWAYS",
        selectedIcon = Icons.Filled.CardGiftcard,
        unselectedIcon = Icons.Outlined.CardGiftcard,
    ),
    NavigationItem(
        title = "FAVORITES",
        selectedIcon = Icons.Filled.Star,
        unselectedIcon = Icons.Outlined.StarBorder,
    ),NavigationItem(
        title = "ABOUT",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info,
    ),
)*/

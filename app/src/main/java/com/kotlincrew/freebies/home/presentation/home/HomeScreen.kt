package com.plcoding.m3_navigationdrawer

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material.icons.outlined.CardGiftcard
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material.icons.outlined.VideogameAsset
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kotlincrew.freebies.home.presentation.home.components.Topbar
import kotlinx.coroutines.launch


@Preview
@Composable
fun HomeScreen() {
    DrawerItemsPrueba()
}

data class NavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    //llamando a este metodo que es Nulable, podemos poner un contador mas adelante,
    // alomejor el numero de cosas que han salido que no llegaste a ver.
    val badgeCount: Int? = null
)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerItemsPrueba() {
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
        ),
        NavigationItem(
            title = "ABOUT",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,


        ),
    )
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        var selectedItemIndex by rememberSaveable {
            mutableStateOf(0)
        }
        ModalNavigationDrawer(
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(modifier = Modifier.height(16.dp))
                    items.forEachIndexed { index, item ->
                        NavigationDrawerItem(label = {
                            Text(text = item.title)
                        }, selected = index == selectedItemIndex, onClick = {
                            //para iniciar el navContrroller podras seguirlo desde el min 10:50 / 13:09 de el vid:
                            //https://www.youtube.com/watch?v=aYSarwALlpI&t=80s&ab_channel=PhilippLackner
//                                            navController.navigate(item.route)



                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        }, icon = {
                            Icon(
                                imageVector = if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon, contentDescription = item.title
                            )
                        }, badge = {
                            item.badgeCount?.let {
                                Text(text = item.badgeCount.toString())
                            }
                        }, modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                    }
                }
            }, drawerState = drawerState
        ) {
            Scaffold(topBar = {
                Topbar {
                    scope.launch {
                        drawerState.open()
                    }
                }
            }) {

            }
        }

    }
}

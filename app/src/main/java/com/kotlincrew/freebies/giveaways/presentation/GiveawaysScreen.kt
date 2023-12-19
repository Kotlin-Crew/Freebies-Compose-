package com.kotlincrew.freebies.giveaways.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotlincrew.freebies.giveaways.presentation.components.GiveawayItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun GiveawaysScreen(
    viewModel: GiveawaysViewModel = hiltViewModel()
){
    var state = viewModel.state

    Scaffold {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.giveaways){
                GiveawayItem(giveaway = it)
            }
        }
    }
}

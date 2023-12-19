package com.kotlincrew.freebies.giveaways.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincrew.freebies.giveaways.domain.usecase.GetGiveawaysUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiveawaysViewModel @Inject constructor(
    private val getAllGiveawaysUseCase: GetGiveawaysUseCase
) : ViewModel() {

    var state by mutableStateOf(GiveawaysState())
        private set

    init {
        getGiveaways()
    }

    private fun getGiveaways(){
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            getAllGiveawaysUseCase().onSuccess {
                state = state.copy(
                    giveaways = it
                )
            }.onFailure {
                state = state.copy(
                    isLoading = true
                )
            }
            state = state.copy(isLoading = false)
        }
    }
}
package com.kotlincrew.freebies.giveaways.presentation

import com.kotlincrew.freebies.giveaways.domain.models.giveaway.Giveaways

data class GiveawaysState(
    val giveaways: List<Giveaways> = emptyList(),
    val isLoading: Boolean = false
)

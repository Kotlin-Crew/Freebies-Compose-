package com.kotlincrew.freebies.giveaways.domain.repository

import com.kotlincrew.freebies.giveaways.domain.models.giveaway.Giveaways

interface GiveawayRepository {
    suspend fun getAllGiveaways(): Result<List<Giveaways>>
}
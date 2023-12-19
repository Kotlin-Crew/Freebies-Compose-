package com.kotlincrew.freebies.giveaways.domain.usecase

import com.kotlincrew.freebies.giveaways.domain.models.giveaway.Giveaways
import com.kotlincrew.freebies.giveaways.domain.repository.GiveawayRepository

class GetGiveawaysUseCase(private val repository: GiveawayRepository) {
    suspend operator fun invoke():Result<List<Giveaways>>{
        return repository.getAllGiveaways()
    }
}
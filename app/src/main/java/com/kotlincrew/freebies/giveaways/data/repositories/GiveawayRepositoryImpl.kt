package com.kotlincrew.freebies.giveaways.data.repositories

import com.kotlincrew.freebies.giveaways.data.remote.GiveawaysApi
import com.kotlincrew.freebies.giveaways.data.remote.dto.giveaways.toGiveaways
import com.kotlincrew.freebies.giveaways.domain.models.giveaway.Giveaways
import com.kotlincrew.freebies.giveaways.domain.repository.GiveawayRepository
import javax.inject.Inject

class GiveawayRepositoryImpl @Inject constructor(private val api: GiveawaysApi): GiveawayRepository{

    override suspend fun getAllGiveaways(): Result<List<Giveaways>> {
        return try{
            val response = api.getAllGiveaways()
            val giveaways = response.map { it.toGiveaways() }
            Result.success(giveaways)
        } catch (e:Exception){
            Result.failure(e)
        }
    }

}
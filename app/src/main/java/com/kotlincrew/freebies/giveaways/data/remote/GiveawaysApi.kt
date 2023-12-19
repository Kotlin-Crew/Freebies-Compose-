package com.kotlincrew.freebies.giveaways.data.remote

import com.kotlincrew.freebies.giveaways.data.remote.dto.giveaways.GiveawaysDto
import retrofit2.http.GET

interface GiveawaysApi {
    companion object{
        const val BASE_URL = "https://www.gamerpower.com/api/"
    }

    @GET("giveaways")
    suspend fun getAllGiveaways(): List<GiveawaysDto>
}
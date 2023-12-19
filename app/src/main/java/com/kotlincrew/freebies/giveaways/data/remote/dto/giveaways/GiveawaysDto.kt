package com.kotlincrew.freebies.giveaways.data.remote.dto.giveaways

import com.kotlincrew.freebies.giveaways.domain.models.giveaway.Giveaways

data class GiveawaysDto(
    val id: Int,
    val image: String,
    val title: String,
    val type: String,
    val worth: String
)

fun GiveawaysDto.toGiveaways(): Giveaways{
    return Giveaways(
        id = id,
        title = title,
        worth = worth,
        type = type,
        image = image
    )
}
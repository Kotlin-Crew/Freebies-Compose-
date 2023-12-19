package com.kotlincrew.freebies.giveaways.di

import com.kotlincrew.freebies.giveaways.data.remote.GiveawaysApi
import com.kotlincrew.freebies.giveaways.data.repositories.GiveawayRepositoryImpl
import com.kotlincrew.freebies.giveaways.domain.repository.GiveawayRepository
import com.kotlincrew.freebies.giveaways.domain.usecase.GetGiveawaysUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideGiveawaysApi(): GiveawaysApi{
        return Retrofit.Builder()
            .baseUrl(GiveawaysApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GiveawaysApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGiveawayRepository( api: GiveawaysApi):GiveawayRepository{
        return GiveawayRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideGiveawaysUseCases(repository: GiveawayRepository):GetGiveawaysUseCase{
        return GetGiveawaysUseCase(repository)
    }
}
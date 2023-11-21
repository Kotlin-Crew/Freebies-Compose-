package com.kotlincrew.freebies.auth.di

import com.kotlincrew.freebies.auth.data.matcher.EmailMatcherImpl
import com.kotlincrew.freebies.auth.data.repository.AuthRepositoryImpl
import com.kotlincrew.freebies.auth.domain.matcher.EmailMatcher
import com.kotlincrew.freebies.auth.domain.repository.AuthRepository
import com.kotlincrew.freebies.auth.domain.usecase.LoginUseCases
import com.kotlincrew.freebies.auth.domain.usecase.LoginWithEmailUseCase
import com.kotlincrew.freebies.auth.domain.usecase.ValidateEmailUseCase
import com.kotlincrew.freebies.auth.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//dependency injection
@Module
@InstallIn(SingletonComponent::class)
object authModule {
    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideEmailMatcher(): EmailMatcher {
        return EmailMatcherImpl()
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(
        repository: AuthRepository,
        emailMatcher: EmailMatcher
    ): LoginUseCases {
        return LoginUseCases(
            loginWithEmailUseCase = LoginWithEmailUseCase(repository),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher)
        )
    }
}
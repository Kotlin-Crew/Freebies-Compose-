package com.kotlincrew.freebies.auth.di

import android.content.Context
import android.content.SharedPreferences
import com.kotlincrew.freebies.auth.data.matcher.EmailMatcherImpl
import com.kotlincrew.freebies.auth.data.repository.AuthRepositoryImpl
import com.kotlincrew.freebies.auth.domain.matcher.EmailMatcher
import com.kotlincrew.freebies.auth.domain.repository.AuthRepository
import com.kotlincrew.freebies.auth.domain.usecase.GetRememberAccountUseCase
import com.kotlincrew.freebies.auth.domain.usecase.GetUserIdUseCase
import com.kotlincrew.freebies.auth.domain.usecase.LoginUseCases
import com.kotlincrew.freebies.auth.domain.usecase.LoginWithEmailUseCase
import com.kotlincrew.freebies.auth.domain.usecase.SetRememberAccountUseCase
import com.kotlincrew.freebies.auth.domain.usecase.SignupUseCases
import com.kotlincrew.freebies.auth.domain.usecase.SignupWithEmailUseCase
import com.kotlincrew.freebies.auth.domain.usecase.ValidateEmailUseCase
import com.kotlincrew.freebies.auth.domain.usecase.ValidatePasswordUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//dependency injection
@Module
@InstallIn(SingletonComponent::class)
object authModule {

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("freebies_login_preference", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(sharedPreferences: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(sharedPreferences)
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
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            SetRememberAccountUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideSignupUseCases(
        repository: AuthRepository,
        emailMatcher: EmailMatcher
    ): SignupUseCases {
        return SignupUseCases(
            signupWithEmailUseCase = SignupWithEmailUseCase(repository),
            validatePasswordUseCase = ValidatePasswordUseCase(),
            validateEmailUseCase = ValidateEmailUseCase(emailMatcher),
            setRememberAccount = SetRememberAccountUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideGetRememberAccount(
        repository: AuthRepository
    ): GetRememberAccountUseCase {
        return GetRememberAccountUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetUserIdUseCase(repository: AuthRepository): GetUserIdUseCase {
        return GetUserIdUseCase(repository)
    }

}
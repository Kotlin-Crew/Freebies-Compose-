package com.kotlincrew.freebies.auth.domain.usecase

data class LoginUseCases(
    val loginWithEmailUseCase: LoginWithEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val setRememberAccount : SetRememberAccountUseCase
)
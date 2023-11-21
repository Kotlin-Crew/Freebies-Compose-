package com.kotlincrew.freebies.auth.domain.usecase

data class SignupUseCases (
    val signupWithEmailUseCase: SignupWithEmailUseCase,
    val validateEmailUseCase: ValidateEmailUseCase,
    val validatePasswordUseCase: ValidatePasswordUseCase,
    val setRememberAccount : SetRememberAccountUseCase
)
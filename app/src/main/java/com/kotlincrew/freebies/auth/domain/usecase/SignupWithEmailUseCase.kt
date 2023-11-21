package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.repository.AuthRepository

class SignupWithEmailUseCase (private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.signup(email, password)
    }
}
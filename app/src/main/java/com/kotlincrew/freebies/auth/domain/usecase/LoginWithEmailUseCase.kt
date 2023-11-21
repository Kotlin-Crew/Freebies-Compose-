package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.repository.AuthRepository

class LoginWithEmailUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        return repository.login(email, password)
    }
}
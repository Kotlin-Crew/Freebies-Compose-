package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.repository.AuthRepository

class GetRememberAccountUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke(): Boolean {
        return repository.getRememberAccount()
    }
}
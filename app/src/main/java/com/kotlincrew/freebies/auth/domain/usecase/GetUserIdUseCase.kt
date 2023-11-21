package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.repository.AuthRepository

class GetUserIdUseCase(private val repository: AuthRepository) {
    operator fun invoke(): String?{
        return repository.getUserId()
    }
}
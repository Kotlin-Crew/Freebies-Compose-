package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.repository.AuthRepository

class SetRememberAccountUseCase(
    private val repository: AuthRepository
) {
    operator fun invoke(isChecked: Boolean) {
        return repository.setRememberAccount(isChecked)
    }
}
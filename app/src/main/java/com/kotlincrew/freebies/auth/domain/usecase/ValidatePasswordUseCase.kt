package com.kotlincrew.freebies.auth.domain.usecase

class ValidatePasswordUseCase {
    operator fun invoke(password: String): PasswordResult {
        if (password.length < 8) {
            return PasswordResult.Invalid("The password must be at least 8 characters long")
        }
        if (!password.any { it.isLowerCase() }) {
            return PasswordResult.Invalid("The password must contain at least 1 lowercase letter")
        }
        if (!password.any { it.isUpperCase() }) {
            return PasswordResult.Invalid("The password must contain at least 1 uppercase letter")
        }
        if (!password.any { it.isDigit() }) {
            return PasswordResult.Invalid("The password must contain at least 1 number")
        }
        return PasswordResult.Valid
    }
}

sealed class PasswordResult() {
    object Valid : PasswordResult()
    data class Invalid(val errorMessage: String) : PasswordResult()
}
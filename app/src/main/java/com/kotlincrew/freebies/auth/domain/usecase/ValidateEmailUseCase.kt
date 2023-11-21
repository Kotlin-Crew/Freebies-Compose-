package com.kotlincrew.freebies.auth.domain.usecase

import com.kotlincrew.freebies.auth.domain.matcher.EmailMatcher

class ValidateEmailUseCase(private val emailMatcher: EmailMatcher) {
    operator fun invoke(email: String): Boolean {
        return emailMatcher.isValid(email)
    }
}
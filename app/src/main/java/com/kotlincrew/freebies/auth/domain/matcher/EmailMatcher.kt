package com.kotlincrew.freebies.auth.domain.matcher

interface EmailMatcher {
    fun isValid(email: String): Boolean
}
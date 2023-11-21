package com.kotlincrew.freebies.auth.presentation.signup

import com.kotlincrew.freebies.auth.presentation.login.LoginEvent

sealed interface SignupEvent {
    data class EmailChange(val email: String) : SignupEvent
    data class PasswordChange(val password: String) : SignupEvent
    object SignUp : SignupEvent
}
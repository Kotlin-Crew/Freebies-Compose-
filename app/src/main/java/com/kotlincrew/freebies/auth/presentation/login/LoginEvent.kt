package com.kotlincrew.freebies.auth.presentation.login

sealed interface LoginEvent {
    data class EmailChange(val email: String) : LoginEvent
    data class PasswordChange(val password: String) : LoginEvent
    data class RememberChange(val remember: Boolean) : LoginEvent
    object Login : LoginEvent
}
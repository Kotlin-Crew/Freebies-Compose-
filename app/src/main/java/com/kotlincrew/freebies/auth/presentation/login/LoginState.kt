package com.kotlincrew.freebies.auth.presentation.login

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val remember: Boolean = false,
    val isLoogedIn: Boolean = false,
    val isLoading: Boolean = false
)
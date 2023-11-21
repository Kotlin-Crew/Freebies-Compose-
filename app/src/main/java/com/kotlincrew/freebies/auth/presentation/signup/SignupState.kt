package com.kotlincrew.freebies.auth.presentation.signup

data class SignupState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isSignedIn: Boolean = false,
    val isLoading: Boolean = false
)
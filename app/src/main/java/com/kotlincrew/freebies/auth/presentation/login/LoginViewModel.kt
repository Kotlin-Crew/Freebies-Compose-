package com.kotlincrew.freebies.auth.presentation.login

import android.preference.PreferenceManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincrew.freebies.auth.domain.usecase.LoginUseCases
import com.kotlincrew.freebies.auth.domain.usecase.PasswordResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }

            LoginEvent.Login -> {
                login()
            }

            is LoginEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }

            is LoginEvent.RememberChange -> {
                state = state.copy(
                    remember = event.remember
                )
            }
        }
    }

    private fun login() {
        //reset values
        state = state.copy(
            emailError = null,
            passwordError = null
        )
        if (!loginUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = "The email is not valid"
            )
        }
        val passwordResult = loginUseCases.validatePasswordUseCase(state.password)
        if (passwordResult is PasswordResult.Invalid) {
            state = state.copy(
                passwordError = passwordResult.errorMessage
            )
        }
        if (state.emailError == null && state.passwordError == null) {
            state = state.copy(
                isLoading = true
            )
            viewModelScope.launch(Dispatchers.IO) {
                loginUseCases.loginWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        isLoogedIn = true
                    )
                    loginUseCases.setRememberAccount(state.remember)
                }.onFailure {
                    val error = it.message
                    state = state.copy(
                        passwordError = error
                    )
                }
                state = state.copy(
                    isLoading = false
                )
            }
        }
    }
}
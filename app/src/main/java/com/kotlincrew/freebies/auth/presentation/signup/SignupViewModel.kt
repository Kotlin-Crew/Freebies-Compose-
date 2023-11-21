package com.kotlincrew.freebies.auth.presentation.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kotlincrew.freebies.auth.domain.usecase.PasswordResult
import com.kotlincrew.freebies.auth.domain.usecase.SetRememberAccountUseCase
import com.kotlincrew.freebies.auth.domain.usecase.SignupUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCases: SignupUseCases,
) : ViewModel() {
    var state by mutableStateOf(SignupState())
        private set

    fun onEvent(event: SignupEvent) {
        when (event) {
            is SignupEvent.EmailChange -> {
                state = state.copy(
                    email = event.email
                )
            }

            is SignupEvent.PasswordChange -> {
                state = state.copy(
                    password = event.password
                )
            }

            SignupEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        //reset values
        state = state.copy(
            emailError = null,
            passwordError = null
        )
        if (!signupUseCases.validateEmailUseCase(state.email)) {
            state = state.copy(
                emailError = "The email is not valid"
            )
        }
        val passwordResult = signupUseCases.validatePasswordUseCase(state.password)
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
                signupUseCases.signupWithEmailUseCase(state.email, state.password).onSuccess {
                    state = state.copy(
                        isSignedIn = true
                    )
                    signupUseCases.setRememberAccount(true)
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
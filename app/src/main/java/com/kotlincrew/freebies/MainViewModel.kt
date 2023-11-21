package com.kotlincrew.freebies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.kotlincrew.freebies.auth.domain.usecase.GetRememberAccountUseCase
import com.kotlincrew.freebies.auth.domain.usecase.GetUserIdUseCase
import com.kotlincrew.freebies.auth.presentation.login.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserIdUseCase: GetUserIdUseCase,
    private val getRememberAccountUseCase: GetRememberAccountUseCase
) : ViewModel() {
    var isLoggedIn by mutableStateOf(getUserIdUseCase() != null)
        private set

    var isRememberChecked by mutableStateOf(getRememberAccountUseCase())
        private set
}
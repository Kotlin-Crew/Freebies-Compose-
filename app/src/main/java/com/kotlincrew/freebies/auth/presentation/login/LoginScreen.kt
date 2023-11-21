package com.kotlincrew.freebies.auth.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kotlincrew.freebies.R
import com.kotlincrew.freebies.core.presentation.FreebiesButton
import com.kotlincrew.freebies.core.presentation.FreebiesDivider
import com.kotlincrew.freebies.core.presentation.FreebiesEmailTextField
import com.kotlincrew.freebies.core.presentation.FreebiesLoadingIndicator
import com.kotlincrew.freebies.core.presentation.FreebiesPasswordTextField
import com.kotlincrew.freebies.ui.theme.freebiesTitleFamily

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onSignUp: () -> Unit,
    onLogin: () -> Unit
) {

    val state = viewModel.state

    LaunchedEffect(state.isLoogedIn) {
        if (state.isLoogedIn) {
            onLogin()
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.background_freebies_login_register),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(
                            fontSize = 32.sp,
                            fontFamily = freebiesTitleFamily,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        append(stringResource(R.string.user))
                    }
                    withStyle(
                        SpanStyle(
                            fontSize = 32.sp,
                            fontFamily = freebiesTitleFamily,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append(stringResource(R.string.login))
                    }
                }
            )
            FreebiesDivider()
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = stringResource(R.string.email),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp,
                fontFamily = freebiesTitleFamily
            )
            FreebiesEmailTextField(
                value = state.email,
                errorMessage = state.emailError,
                onValueChange = { viewModel.onEvent(LoginEvent.EmailChange(it)) })
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = stringResource(R.string.password),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 24.sp,
                fontFamily = freebiesTitleFamily
            )
            FreebiesPasswordTextField(
                value = state.password,
                errorMessage = state.passwordError,
                onValueChange = { viewModel.onEvent(LoginEvent.PasswordChange(it)) }
            )
            Row(
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    modifier = Modifier.absoluteOffset((-12).dp, 0.dp),
                    checked = state.remember,
                    onCheckedChange = { viewModel.onEvent(LoginEvent.RememberChange(it)) })
                Text(
                    modifier = Modifier.absoluteOffset((-12).dp, 0.dp),
                    text = stringResource(R.string.remember_me),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.background
                )
            }
            Text(
                modifier = Modifier.align(Alignment.Start),
                text = stringResource(R.string.forgot_password),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.background
            )
            Spacer(modifier = Modifier.height(8.dp))
            FreebiesButton(
                onClick = { viewModel.onEvent(LoginEvent.Login) },
                text = stringResource(R.string.login_button),
                size = 20
            )
            Spacer(modifier = Modifier.height(16.dp))
            FreebiesDivider()
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(R.string.not_member),
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodyMedium
            )
            FreebiesButton(
                onClick = { onSignUp() },
                text = stringResource(R.string.sign_up),
                size = 20
            )
        }

        if (state.isLoading) {
            FreebiesLoadingIndicator()
        }
    }
}
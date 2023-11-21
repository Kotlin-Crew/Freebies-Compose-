package com.kotlincrew.freebies.core.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.kotlincrew.freebies.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreebiesEmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    errorMessage: String? = null,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        TextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                autoCorrect = false
            ),
            value = value,
            isError = errorMessage != null,
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyMedium,
            onValueChange = { onValueChange(it) },
            placeholder = {
                Text(
                    stringResource(R.string.email_hint),
                    style = MaterialTheme.typography.bodyMedium
                )
            },
            shape = RoundedCornerShape(5.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Gray,
                unfocusedBorderColor = Color.LightGray,
                textColor = Color.Black,
                cursorColor = Color.Gray,
                containerColor = MaterialTheme.colorScheme.secondary,
            ),
            modifier = modifier.height(54.dp),
        )
        if (errorMessage != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }

}
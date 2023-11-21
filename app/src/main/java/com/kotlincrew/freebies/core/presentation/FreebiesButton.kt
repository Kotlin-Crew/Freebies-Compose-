package com.kotlincrew.freebies.core.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlincrew.freebies.ui.theme.freebiesBodyFamily

@Composable
fun FreebiesButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String,
    size: Int
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = text,
            fontSize = size.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = freebiesBodyFamily
        )
    }
}
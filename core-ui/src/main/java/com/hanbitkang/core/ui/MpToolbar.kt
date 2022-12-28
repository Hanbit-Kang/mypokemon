package com.hanbitkang.core.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MpToolbar(
    title: String? = null,
    onClickBackButton: (() -> Unit)? = null,
    fontSize: Int = 18,
    verticalPadding: Int = 8
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, verticalPadding.dp)
    ) {
        if (onClickBackButton != null) {
            IconButton(
                onClick = { onClickBackButton() },
                modifier = Modifier
                    .align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
        }

        Text(
            title ?: "",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            textAlign = TextAlign.Center,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}
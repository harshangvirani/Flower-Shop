package com.app.flowerui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flowerui.ui.theme.dark_gray

@Composable
fun PagingIndicator(
    currentPage: Int,
    totalPage: Int
) {
    val currentPages = currentPage - 1
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyRow(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            items(totalPage) {
                Box(
                    modifier = Modifier
                        .size(if (it == currentPages) 10.dp else 8.dp)
                        .clip(CircleShape)
                        .background(if (it == currentPages) dark_gray else Color.LightGray)
                )

                Spacer(modifier = Modifier.padding(horizontal = 4.dp))
            }

        }
    }
}

@Preview
@Composable
fun PagingIndicatorPreview() = PagingIndicator(currentPage = 1, totalPage = 5)

package com.app.flowerui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flowerui.ui.theme.colorPrimary

@Composable
fun TopAppBar(
    title: String,
    onBackClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
            .background(color = Color.Transparent),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onBackClick }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "On Back",
                tint = colorPrimary,
                modifier = Modifier.size(32.dp, 32.dp)
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            color = colorPrimary,
        )

        Row {
            IconButton(onClick = { onBackClick }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "On Back",
                    tint = colorPrimary,
                    modifier = Modifier.size(32.dp, 32.dp)
                )
            }
            IconButton(onClick = { onBackClick }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "On Back",
                    tint = colorPrimary,
                    modifier = Modifier.size(32.dp, 32.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun TopAppBarPreview() = TopAppBar(title = "Popular Flowers") {}
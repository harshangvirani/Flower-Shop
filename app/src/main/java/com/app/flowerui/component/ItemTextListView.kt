package com.app.flowerui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flowerui.R
import com.app.flowerui.ui.theme.colorPrimary
import com.app.flowerui.utils.FlowersList

@Composable
fun ItemText(
    title: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(id = title),
            color = Color.Black,
            style = MaterialTheme.typography.titleMedium
        )

        TextButton(onClick = { /*TODO*/ }) {
            Text(
                text = stringResource(id = R.string.view_all),
                style = MaterialTheme.typography.titleMedium,
                color = colorPrimary
            )
        }
    }
}

@Preview
@Composable
fun ItemTextPreview() = ItemText(title = R.string.popular_items)

@Preview
@Composable
fun FlowerListView() {
    val data = FlowersList()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(data) {
            FlowerItemCardDesign(it, Modifier.padding(end = 8.dp))
        }
    }
}
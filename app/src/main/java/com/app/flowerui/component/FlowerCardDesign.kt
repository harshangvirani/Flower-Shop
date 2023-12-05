package com.app.flowerui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.flowerui.R
import com.app.flowerui.modal.FlowerItemModal
import com.app.flowerui.ui.theme.ShapesItem
import com.app.flowerui.ui.theme.colorPrimary
import com.app.flowerui.ui.theme.white


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowerItemCardDesign(flowerItemModal: FlowerItemModal,modifier: Modifier) {
    Card(
        onClick = { /*TODO*/ },
        modifier = modifier
            .size(250.dp)
            .background(color = white),
        shape = ShapesItem.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = flowerItemModal.flowerImages),
                contentDescription = "Item Image",
                modifier = Modifier.size(150.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.wrapContentWidth()
                ) {
                    Text(
                        text = flowerItemModal.name,
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Text(
                        text = "$ " + flowerItemModal.price,
                        style = MaterialTheme.typography.titleLarge,
                        color = colorPrimary
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = colorPrimary,
                        contentColor = white
                    ),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FlowerItemDesign() = FlowerItemCardDesign(
    flowerItemModal = FlowerItemModal(
        flowerImages = R.drawable.ic_red_rose_bouquet,
        name = "Angle",
        price = 65
    ),Modifier
)
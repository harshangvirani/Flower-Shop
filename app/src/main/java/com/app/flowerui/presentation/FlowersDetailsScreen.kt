package com.app.flowerui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.flowerui.R
import com.app.flowerui.component.FlowerListView
import com.app.flowerui.component.ItemCounter
import com.app.flowerui.component.ItemText
import com.app.flowerui.component.PagingIndicator
import com.app.flowerui.component.TopAppBar
import com.app.flowerui.ui.theme.ShapesItem
import com.app.flowerui.ui.theme.colorPrimary
import com.app.flowerui.ui.theme.colorprimarywhite
import com.app.flowerui.ui.theme.text_hint_color
import com.app.flowerui.ui.theme.white
import com.app.flowerui.utils.SliderListImageView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlowersDetailsScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(text_hint_color)
            .verticalScroll(rememberScrollState()),
        topBar = { TopAppBar(title = "", showIcon = 1) {} }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SliderImageView()
            Spacer(modifier = Modifier.height(18.dp))
            DetailsView()
            Spacer(modifier = Modifier.height(16.dp))
            ItemText(title = R.string.similar_products, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(16.dp))
            FlowerListView()
        }
    }
}

@Preview
@Composable
fun FlowersDetailsScreenPreview() =
    FlowersDetailsScreen(navController = NavHostController(LocalContext.current))

@Preview
@Composable
fun SliderImageView() {
    val listData = SliderListImageView()
    var currentImage: Int = 1
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(listData) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(350.dp, 180.dp)
                )
                currentImage = it.pageNumber
            }
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
    PagingIndicator(currentPage = currentImage, totalPage = listData.size)
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DetailsView() {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(35.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorPrimary,
            contentColor = white
        )
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        TitleAndSubtitle()
        Spacer(modifier = Modifier.height(16.dp))
        PriceAndItemCount()
        Spacer(modifier = Modifier.height(16.dp))
        AboutItemCount()
        Spacer(modifier = Modifier.height(16.dp))
        ButtonItem()
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun TitleAndSubtitle() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Jannien Flower Bouquet",
            style = MaterialTheme.typography.titleLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "includes jannein flower, lily leaves",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun PriceAndItemCount() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$ 123.00",
            style = MaterialTheme.typography.titleLarge,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
        )
        ItemCounter()
    }
}

@Preview
@Composable
fun AboutItemCount() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            text = "About",
            style = MaterialTheme.typography.titleLarge,
            color = white
        )
        Spacer(modifier = Modifier.padding(5.dp))

        Text(
            text = "Lorem ipsum is simply dummy text of the printing and \n" +
                    "typesetting industry. Loremk ipsum has been the industy's \n" +
                    "standard dummy text ever since the 1500s.",
            style = MaterialTheme.typography.bodyMedium,
            color = white
        )
    }
}

@Preview
@Composable
fun ButtonItem() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(60.dp),
            shape = ShapesItem.medium,
            colors = ButtonDefaults.buttonColors(
                contentColor = colorPrimary,
                containerColor = white
            )
        ) {
            Text(
                text = "Add to Cart",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = colorPrimary,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(30.dp)
            )
        }
    }
}
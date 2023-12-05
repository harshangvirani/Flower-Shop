package com.app.flowerui.presentation

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.flowerui.R
import com.app.flowerui.component.FlowerItemCardDesign
import com.app.flowerui.ui.theme.ShapesItem
import com.app.flowerui.ui.theme.colorPrimary
import com.app.flowerui.ui.theme.dark_gray
import com.app.flowerui.ui.theme.text_hint_color
import com.app.flowerui.ui.theme.white
import com.app.flowerui.utils.CategoryListItem
import com.app.flowerui.utils.FlowersList
import com.app.flowerui.utils.SliderList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(text_hint_color)
            .verticalScroll(rememberScrollState()),
        topBar = {
            TopAppBarHome()
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            SlidingBannerViews()
            Spacer(modifier = Modifier.height(18.dp))
            CategoryViews()
            Spacer(modifier = Modifier.height(16.dp))
            PopularItemText()
            Spacer(modifier = Modifier.height(16.dp))
            FlowerListView()
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun HomeDesignPreview() = HomeScreen(navController = NavHostController(LocalContext.current))

@Preview
@Composable
fun TopAppBarHome() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 8.dp),
        shape = ShapesItem.medium,
        border = BorderStroke(2.dp, colorPrimary),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = colorPrimary
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "FloraGoGo",
                color = colorPrimary,
                fontSize = 24.sp,
                letterSpacing = 2.sp,
                modifier = Modifier.fillMaxWidth(0.7f),
                textAlign = TextAlign.Center
            )

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = colorPrimary,
                    modifier = Modifier
                        .size(32.dp, 32.dp)
                        .fillMaxWidth(0.1f)
                )
            }

            Image(
                painter = painterResource(id = R.drawable.ic_user_account),
                contentDescription = "User Account",
                modifier = Modifier
                    .size(32.dp, 32.dp)
                    .fillMaxWidth(0.1f)
            )

            Spacer(modifier = Modifier.fillMaxWidth(0.1f))

        }
    }
}

@Preview
@Composable
fun SlidingBannerViews() {
    val ListData = SliderList()
    var currentPage: Int = 1
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        items(ListData) {
            Image(
                painter = painterResource(id = it.icon),
                contentDescription = "",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp)
            )
            currentPage = it.pageNumber
        }
    }
    Spacer(modifier = Modifier.height(12.dp))
    PagingIndicator(currentPage = currentPage, totalPage = ListData.size)
}

@Preview
@Composable
fun CategoryViews() {
    val ListData = CategoryListItem()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items(ListData) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(shape = ShapesItem.medium, color = white)
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = it.icon),
                    contentDescription = "CategoryIcon",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

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

@Preview
@Composable
fun PopularItemText() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = stringResource(id = R.string.popular_items),
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
fun FlowerListView() {
    val data = FlowersList()
    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        items(data) {
            FlowerItemCardDesign(it,Modifier.padding(end = 8.dp))
        }
    }
}

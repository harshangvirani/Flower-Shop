package com.app.flowerui.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.app.flowerui.R
import com.app.flowerui.component.FlowerItemCardDesign
import com.app.flowerui.component.TopAppBar
import com.app.flowerui.ui.theme.text_hint_color
import com.app.flowerui.utils.PopularFlowersList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularFlowerScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(text_hint_color)
            .verticalScroll(rememberScrollState()),
        topBar = {
            TopAppBar(title = stringResource(id = R.string.popular_flowers), showIcon = 1) {}
        }
    ) {
        it.calculateBottomPadding()
        PopularFlowerList()
    }
}

@Preview
@Composable
fun PopularFlowerScreenPreview() = PopularFlowerScreen(navController = NavHostController(LocalContext.current))

@Preview
@Composable
fun PopularFlowerList() {
    val data = PopularFlowersList()
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 16.dp),
        userScrollEnabled = true
    ) {
        items(data) {
            FlowerItemCardDesign(flowerItemModal = it, Modifier.padding(all = 8.dp))
        }
    }
}
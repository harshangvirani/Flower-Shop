package com.app.flowerui.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.app.flowerui.R
import com.app.flowerui.component.ItemCounter
import com.app.flowerui.component.TopAppBar
import com.app.flowerui.modal.FlowerItemModal
import com.app.flowerui.ui.theme.ShapesItem
import com.app.flowerui.ui.theme.black
import com.app.flowerui.ui.theme.colorPrimary
import com.app.flowerui.ui.theme.gray
import com.app.flowerui.ui.theme.text_hint_color
import com.app.flowerui.ui.theme.white
import com.app.flowerui.utils.FlowerOrderListView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartItemScrceen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(text_hint_color)
            .verticalScroll(rememberScrollState()),
        topBar = { TopAppBar(title = stringResource(id = R.string.my_cart), showIcon = 0) {} }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            val listData = FlowerOrderListView()

            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 4.dp,
                color = gray
            )
            AddressView()
            Divider(
                modifier = Modifier.fillMaxWidth(),
                thickness = 4.dp,
                color = gray
            )
            if (listData.isEmpty()) {
                NoItemFound()
            } else {
                //FlowerItemView(listData)
                listData.map {
                    FlowerItem(flowerItemModal = it)
                }
                Spacer(modifier = Modifier.height(16.dp))
                ApplyCoupons()
                Spacer(modifier = Modifier.height(16.dp))
                BillsDetailsView()
            }
        }
    }
}

@Preview
@Composable
fun CartItemScreenPreview() =
    CartItemScrceen(navController = NavHostController(LocalContext.current))

@Preview
@Composable
fun AddressView() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .weight(weight = 0.6f, fill = true)
            ) {
                Text(
                    text = buildAnnotatedString {
                        append("Deliver to:")
                        addStyle(
                            SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Normal
                            ),
                            0,
                            this.length
                        )
                        append("Harshang Virani")
                        addStyle(
                            SpanStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                            ),
                            0,
                            this.length
                        )
                    },
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1
                )
                Text(
                    text = stringResource(id = R.string.address_details),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                )
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(weight = 0.4f, fill = true)
                    .padding(16.dp)
                    .size(height = 50.dp, width = 250.dp),
                shape = ShapesItem.medium,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorPrimary,
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(width = 2.dp, color = colorPrimary)
            ) {
                Text(
                    text = stringResource(id = R.string.change),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}

@Composable
fun FlowerItemView(listData: List<FlowerItemModal>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        userScrollEnabled = false,
        contentPadding = PaddingValues(4.dp)
    ) {
        items(listData) {
            FlowerItem(it)
        }
    }
}

@Composable
fun FlowerItem(flowerItemModal: FlowerItemModal) {
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(white)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .weight(0.3f)
                    .height(70.dp)
                    .clip(RoundedCornerShape(12.dp)),
            ) {
                Image(
                    modifier = Modifier
                        .size(70.dp),
                    painter = painterResource(id = flowerItemModal.flowerImages),
                    contentDescription = "",
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .weight(0.9f)
                    .wrapContentHeight()
            ) {
                Text(
                    text = flowerItemModal.name,
                    fontSize = 16.sp,
                    color = black,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$" + flowerItemModal.price,
                    fontSize = 16.sp,
                    color = colorPrimary,
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quantity:",
                        color = Color.Gray,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    ItemCounter()
                }
            }
        }
    }
}

@Preview
@Composable
fun FlowerItemPreview() = FlowerItem(
    flowerItemModal = FlowerItemModal(
        flowerImages = R.drawable.ic_red_rose_bouquet,
        name = "Red Rose",
        price = 65
    )
)

@Preview
@Composable
fun NoItemFound() {
    Text(
        text = stringResource(id = R.string.no_item_found),
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxSize(),
        style = MaterialTheme.typography.titleLarge,
        textAlign = TextAlign.Center,
        color = colorPrimary,
        fontSize = 30.sp
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ApplyCoupons() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight()
    ) {
        Text(
            text = stringResource(id = R.string.apply_coupon),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {

            var userapplycode by remember { mutableStateOf("") }

            TextField(
                value = userapplycode,

                colors = TextFieldDefaults.textFieldColors(
                    containerColor = white,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(top = 10.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = stringResource(id = R.string.enter_code)) },
                shape = RoundedCornerShape(8.dp),
                onValueChange = {
                    userapplycode = it
                }
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Button(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    containerColor = colorPrimary
                ),
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .height(55.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.apply),
                    color = white
                )
            }
        }
    }
}

@Preview
@Composable
fun BillsDetailsView() {
    val listData = FlowerOrderListView()
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = ShapesItem.medium
    ) {
        Text(
            text = stringResource(id = R.string.price_details),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        listData.map {
            BillItem(it.name,it.price)
        }
        BillItem(detail = stringResource(id = R.string.delivery_charges), price = 0)
        BillItem(detail = stringResource(id = R.string.coupon_discount), price = 0)
        Spacer(modifier = Modifier.height(4.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 2.dp,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(4.dp))
        TotalBillItem(detail = stringResource(id = R.string.total_amount_payment), price = 218)
        Spacer(modifier = Modifier.height(16.dp))
        OrderButtonItem()
    }
}

@Composable
fun BillItem(detail:String,price:Int) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = detail,
            fontSize =14.sp,
            color = gray
        )
        Text(
            text ="$"+ price,
            fontSize = 14.sp,
            color = gray
        )
    }
}

@Composable
fun TotalBillItem(detail:String,price:Int) {

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = detail,
            fontSize =20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text ="$"+ price,
            fontSize = 20.sp,
            color = colorPrimary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun OrderButtonItem() {
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
                contentColor = white,
                containerColor = colorPrimary
            )
        ) {
            Text(
                text = stringResource(id = R.string.order),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                imageVector = Icons.Default
                    .ShoppingCart,
                contentDescription = null,
                tint = white,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(30.dp)
            )
        }
    }
}
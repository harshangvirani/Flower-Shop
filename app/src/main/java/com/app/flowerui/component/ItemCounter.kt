package com.app.flowerui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.flowerui.R
import com.app.flowerui.ui.theme.colorprimarywhite
import com.app.flowerui.ui.theme.white

@Preview
@Composable
fun ItemCounter(){
    val itemCount = remember { mutableStateOf(1) }
    Box(
        modifier = Modifier
            .width(110.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(10.dp))
            .background(colorprimarywhite),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                if (itemCount.equals(1)) {
                    itemCount.value--
                }
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_minimize_24),
                    contentDescription = "",
                    modifier = Modifier.padding(bottom = 15.dp),
                    tint = white
                )
            }
            Text(
                text = "${itemCount.value}",
                color = white,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            IconButton(onClick = {
                itemCount.value++
            }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = white,
                )
            }
        }
    }
}
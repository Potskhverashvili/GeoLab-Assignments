package com.example.assignment15

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Product(
    productId: Int,
    name: String,
    price: Int,
    color: String,
    size: String
) {
    val amount by remember { mutableStateOf(1) }
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(color = Color.White)
    ) {

        // ---- Image ---
        Image(
            modifier = Modifier.size(104.dp),
            painter = painterResource(productId),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .fillMaxWidth()
        ) {
            // --- Product Name ---
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )

            // --- Product Color and Size ----
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Text(
                        text = "Color: ",
                        color = Color.Gray
                    )
                    Text(text = color)
                }
                Row {
                    Text(
                        text = "Size: ",
                        color = Color.Gray
                    )
                    Text(text = size)
                }
                Icon(Icons.Default.MoreVert, contentDescription = null)
            }

            // -------- Buttons and Price -------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .width(46.dp) //
                        .height(46.dp) //
                ) {
                    Icon(painter = painterResource(R.drawable.ic_minus), contentDescription = null)
                }
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = amount.toString(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.padding(8.dp))
                IconButton(
                    onClick = {},
                    modifier = Modifier
                        .width(36.dp) //
                        .height(36.dp) //
                ) {
                    Icon(Icons.Default.Add, contentDescription = null)
                }

                // ----- Price ------
                Spacer(modifier = Modifier.padding(48.dp))
                Text(
                    text = ("${price}$"),
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
package com.example.assignment15

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BagScreen() {

    // Items for bottom bar
    val tabItems = listOf("Home", "Shop", "Bag", "Favorite", "Profile")

    // Save index number of tab when user click on Bar item
    val selectedItem = remember { mutableIntStateOf(0) }

    // Text for textField
    var text = remember { mutableStateOf("") }

    var totalAmount = remember { mutableStateOf(0) }

    Scaffold(
        // ------------------------ Top Bar -------------------------
        topBar = {
            LargeTopAppBar(

                title = {
                    Text(
                        text = "My Bag",
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Search,
                            contentDescription = null
                        )
                    }
                }
            )
        },

        // ----------------------- Bottom Bar ------------------------
        bottomBar = {
            NavigationBar {
                // Iterate through a list of tab items
                tabItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItem.intValue == index,
                        onClick = {
                            selectedItem.intValue = index
                        },
                        icon = {
                            /*Log.d("MyLog", "index: ${index.toString()}")
                            Log.d("MyLog", "item: ${item.toString()}")*/
                            // Dynamically select the icon based on the tab item
                            when (item) {
                                "Home" -> Icon(
                                    painter = painterResource(R.drawable.ic_home),
                                    contentDescription = null,
                                    tint = if (selectedItem.intValue == index) Color.Red else Color.Black
                                )

                                "Shop" -> Icon(
                                    painter = painterResource(R.drawable.ic_shop),
                                    contentDescription = null,
                                    tint = if (selectedItem.intValue == index) Color.Red else Color.Black
                                )

                                "Bag" -> Icon(
                                    painter = painterResource(R.drawable.ic_bag),
                                    contentDescription = null,
                                    tint = if (selectedItem.intValue == index) Color.Red else Color.Black
                                )

                                "Favorite" -> Icon(
                                    painter = painterResource(R.drawable.ic_favorite),
                                    contentDescription = null
                                )

                                "Profile" -> Icon(
                                    painter = painterResource(R.drawable.ic_profile),
                                    contentDescription = null,
                                    tint = if (selectedItem.intValue == index) Color.Red else Color.Black
                                )
                            }
                        },
                        label = {
                            Text(
                                text = item,
                                textAlign = TextAlign.Center,
                                color = if (selectedItem.intValue == index) Color.Red else Color.Black
                            )
                        }
                    )

                }
            }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            // --------------------- Products ----------------------
            Product(
                R.drawable.img_product1,
                "Pullover",
                53,
                "Black",
                "L"
            )
            Product(
                R.drawable.img_product2,
                "T-Shirt",
                30,
                "Gray",
                "L"
            )

            Product(
                R.drawable.img_product3,
                "Sport Dress",
                43,
                "Black",
                "M"
            )

            // ------------------- Text Field --------------

            /* TextField(
                 value = text,
                 onValueChange = { newText ->
                     text = newText
                 },
                 label = { Text(text = "Enter your promo code") }
             )


             // -------------------- Total Amount ---------------
             Row(
                 modifier = Modifier.fillMaxWidth()
             ) {
                 Text(text ="Total amount: ")

                 Text(text = totalAmount.toString())
             }*/

            // ------------------- Check out button ------------------
            Button(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .background(Color.Red)
                    .fillMaxWidth(),
                onClick = {}
            ) {
                Text(text = "CHECK OUT")
            }

        }
    }
}

@Preview
@Composable
private fun BagScreenPreview() {
    BagScreen()
}
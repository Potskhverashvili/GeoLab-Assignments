package com.example.assignment15

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BagScreen() {

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

                NavigationBarItem( // Home
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_home),
                            contentDescription = null
                        )
                    },
                    label = {
                        Text(
                            text = "Home"

                        )
                    }
                )

                NavigationBarItem( // Shopping Card
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(Icons.Default.ShoppingCart, contentDescription = null)
                    },
                    label = { Text(text = "Shop") }
                )

                NavigationBarItem(
                    selected = false,
                    onClick = {},
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_bag),
                            contentDescription = null
                        )

                    },

                    label = { Text(text = "Bag") }
                )


            }

        }

    ) { paddingValues ->

    }

}

@Preview
@Composable
private fun BagScreenPreview() {
    BagScreen()
}
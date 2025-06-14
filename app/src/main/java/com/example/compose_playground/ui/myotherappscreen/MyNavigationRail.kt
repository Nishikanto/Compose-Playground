package com.example.compose_playground.ui.myotherappscreen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier
    ) {
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon"
                )
            },
            label = {
                Text("Home")
            },
            selected = true,
            onClick = {

            }
        )
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "Profile Icon"
                )
            },
            label = {
                Text("Profile")
            },
            selected = false,
            onClick = {

            }
        )
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon"
                )
            },
            label = {
                Text("Settings")
            },
            selected = false,
            onClick = {

            }
        )
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            label = {
                Text("Search")
            },
            selected = false,
            onClick = {

            }
        )
    }
}

@Composable
@Preview
fun MyNavigationRailPreview() {
    MyNavigationRail()
}
package com.example.compose_playground.ui.myotherappscreen

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.doOnAttach

@Composable
fun MyOtherApp(windowSizeClass: WindowSizeClass) {
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MyOtherAppPortrait()
        }

        WindowWidthSizeClass.Expanded -> {
            MyOtherAppLandscape()
        }
    }
}

@Composable
fun MyOtherAppPortrait() {
    Scaffold(
        bottomBar = { MyNavigationBar() }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Portrait Mode",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun MyOtherAppLandscape() {
    val cutoutOnLeft by rememberCutoutOnLeft()

    val insets = if (cutoutOnLeft) {
        WindowInsets.safeContent
    } else {
        WindowInsets.systemBars
    }

    Scaffold(
        contentWindowInsets = insets,
        content = { padding ->
            Row(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surface)
            ) {
                MyNavigationRail()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Landscape Mode",
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    )
}

@Composable
fun rememberCutoutOnLeft(): MutableState<Boolean> {
    val context = LocalContext.current
    val view = LocalView.current
    val isLeftCutout = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        view.doOnAttach {
            val insets = ViewCompat.getRootWindowInsets(it)
            val cutout = insets?.displayCutout
            val leftInset = cutout?.safeInsetLeft ?: 0
            val rightInset = cutout?.safeInsetRight ?: 0

            // In landscape mode, left inset > 0 usually means punch hole or notch on left
            val isLandscape = context.resources.configuration.orientation ==
                    Configuration.ORIENTATION_LANDSCAPE

            isLeftCutout.value = isLandscape && leftInset > rightInset && leftInset > 0
        }
    }

    return isLeftCutout
}
package com.example.compose_playground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.compose_playground.ui.myotherappscreen.MyOtherApp
import com.example.compose_playground.ui.mystateexerappscreen.MyStateExerApp
import com.example.compose_playground.ui.theme.ComposePlaygroundTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePlaygroundTheme {
                MyStateExerApp()
            }

            
//            val windowSizeClass = calculateWindowSizeClass(this)
//            ComposePlaygroundTheme {
//                MyOtherApp(windowSizeClass)
//            }
        }
    }
}




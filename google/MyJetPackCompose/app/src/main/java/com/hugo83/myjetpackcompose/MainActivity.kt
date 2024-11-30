package com.hugo83.myjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hugo83.myjetpackcompose.ui.theme.MyJetPackComposeTheme
import com.hugo83.myjetpackcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Greeting()
            }
        }
    }
}

@Composable
private fun MyTheme(content: @Composable() () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Purple80,
            secondary = Pink80
        ),
        typography = Typography,
        shapes = Shapes(),
    ) {
        content()
    }
}


@Composable
fun Greeting() {
    Text( text = "Hello Kotlin" )
}

@Preview
@Composable
fun GreetingPreview() {
    MyTheme {
        Greeting()
    }
}
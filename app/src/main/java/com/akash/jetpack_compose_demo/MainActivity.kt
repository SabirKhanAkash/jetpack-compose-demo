package com.akash.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme
import com.akash.jetpack_compose_demo.ui.theme.LatoFont

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposedemoTheme {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {

                    Text(
                        text = "Hello World",
                        modifier = Modifier.align(Alignment.Center),
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Icon(
                        painter = painterResource(
                            id = R.drawable.login_logo,

                            ),
                        modifier = Modifier.fillMaxSize(),
                        contentDescription = "logo"
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(50.dp, Alignment.CenterVertically)
                ) {
                    Text(
                        text = "Career Objective",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Education",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Work Experience",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Skills",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    TextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Enter your name")
                        }
                    )
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.login_footer),
                            contentDescription = "floating button logo"
                        )
                    }
                }

                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Home",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "About",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Contact",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Text(
                        text = "Career",
                        fontFamily = LatoFont,
                        fontSize = 20.sp
                    )
                    Button(
                        onClick = { },
                        content = {
                            Text(text = "Click me")
                        },
                        shape = ButtonDefaults.elevatedShape
                    )
                }
            }
        }
    }
}

@Composable
fun CustomButton(text: String) {
    Button(
        onClick = { },
        content = {
            Text(text = text)
        },
        shape = ButtonDefaults.elevatedShape
    )
}
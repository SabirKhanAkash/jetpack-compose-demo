@file:OptIn(ExperimentalMaterial3Api::class)

package com.akash.jetpack_compose_demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(height = 224.dp, width = 224.dp)
                            .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
                            .clip(CircleShape)
                            .border(3.dp, Color.Red, CircleShape)
                            .background(color = Color.Blue, shape = RectangleShape)
                            .clickable {
                                Log.d("test", "Blue Box is clicked")
                                Toast.makeText(
                                    applicationContext,
                                    "Blue Box is clicked",
                                    Toast.LENGTH_SHORT
                                )
                            },
                        contentAlignment = Alignment.Center,
                    ) {

                        Text(
                            text = "My Fully Circled Item",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(5.dp),
                            fontFamily = LatoFont,
                            fontSize = 20.sp
                        )
                        Icon(
                            painter = painterResource(
                                id = R.drawable.login_logo,
                            ),
                            modifier = Modifier.size(125.dp),
                            contentDescription = "logo"
                        )
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    Box(
                        modifier = Modifier
                            .size(height = 224.dp, width = 224.dp)
                            .padding(start = 5.dp, top = 10.dp, end = 5.dp, bottom = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .border(5.dp, Color.Green, RoundedCornerShape(10.dp))
                            .background(color = Color.Transparent, shape = RectangleShape)
                            .clickable {
                                Log.d("test", "Transparent Box is clicked")
                                Toast.makeText(
                                    applicationContext,
                                    "Transparent Box is clicked",
                                    Toast.LENGTH_SHORT
                                )
                            },
                        contentAlignment = Alignment.Center,
                    ) {

                        Text(
                            text = "My Rounded Corner Item",
                            modifier = Modifier
                                .align(Alignment.Center)
                                .padding(12.dp),
                            fontFamily = LatoFont,
                            fontSize = 17.sp
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 5.dp, vertical = 10.dp),
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
                }

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 5.dp, vertical = 10.dp),
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

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 5.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MyStateFulTextField("This is a stateful Textbox")
                    Spacer(modifier = Modifier.size(8.dp))
                    var textState by rememberSaveable {
                        mutableStateOf("")
                    }
                    val namesListState = remember {
                        mutableStateListOf<String>()
                    }
//                    LazyColumn(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f),
//                    ) {
//                        items(namesListState.size) {
//                            Text(text = namesListState[it])
//                        }
//                    }
                    MyStatelessTextField(
                        textState,
                        onChange = {
                            textState = it
                        },
                        "This is a stateless Textbox",
                        onAddClick = {
                            namesListState.add(textState)
                            textState = ""
                        }
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.login_footer),
                            contentDescription = "floating button logo"
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MyStateFulTextField(hint: String) {
    var nameState by remember {
        mutableStateOf("")
    }
    TextField(
        value = nameState,
        onValueChange = {
            nameState = it
        },
        label = {
            Text(text = hint)
        },
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun MyStatelessTextField(
    text: String,
    onChange: (String) -> Unit,
    hint: String,
    onAddClick: () -> Unit
) {
    TextField(
        value = text,
        onValueChange = { onChange(it) },
        label = {
            Text(text = hint)
        },
        modifier = Modifier.fillMaxWidth(),
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "this is an add icon",
                modifier = Modifier.clickable {
                    Log.d("test", text)
                    onAddClick
                }
            )
        }
    )
}
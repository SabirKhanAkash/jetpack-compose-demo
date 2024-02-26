@file:OptIn(ExperimentalMaterial3Api::class)

package com.akash.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.jetpack_compose_demo.ui.component.Author
import com.akash.jetpack_compose_demo.ui.component.CustomCard
import com.akash.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme
import com.akash.jetpack_compose_demo.ui.theme.LatoFont

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackcomposedemoTheme {
                // Outlined Textbox's Text state
                var keyTextState by rememberSaveable {
                    mutableStateOf("")
                }

                // key visibility state
                var isKeyVisible by rememberSaveable {
                    mutableStateOf(false)
                }

                var tintColor by remember {
                    mutableStateOf(Color.Black)
                }

                // Proceed Button State
                var enableState by remember {
                    mutableStateOf(true)
                }

                var cardContentBody by rememberSaveable {
                    mutableStateOf("This is the main background of our upcoming android project. It is going to be developed in Kotlin. Also we are using latest jetpack compose for the UI instead of old traditional XML.")
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Random Texts
                    Text(
                        modifier = Modifier
                            .padding(20.dp)
                            .align(Alignment.CenterHorizontally),
                        text = stringResource(id = R.string.app_name)
                            .plus(" ")
                            .repeat(20),
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = LatoFont,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Justify
                    )

                    // Gradient Text
                    val annotatedString = buildAnnotatedString {
                        blueGradientText(stringResource(id = R.string.gradient_text))
                    }

                    Text(text = annotatedString)

                    // Custom Card
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White.copy(alpha = 0.8f)),
                        contentAlignment = Alignment.Center
                    ) {
                        CustomCard(
                            modifier = Modifier
                                .padding(20.dp)
                                .background(Color.Transparent),
                            image = R.drawable.login_background,
                            title = stringResource(id = R.string.card_content_title),
                            text = cardContentBody,
                            author = Author(
                                name = stringResource(id = R.string.card_content_author_name),
                                job = stringResource(id = R.string.card_content_author_job_title),
                                image = R.drawable.app_logo
                            )
                        )
                    }

                    // new line
                    Spacer(modifier = Modifier.size(10.dp))

                    // Outlined Textbox
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp),
                        value = keyTextState,
                        onValueChange = {
                            keyTextState = it
                        },
                        placeholder = {
                            Text(text = stringResource(id = R.string.secret_key_textbox_prompt))
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.LightGray,
                            cursorColor = Color.Blue,
                            textColor = Color.Black
                        ),
                        singleLine = true,
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "lock icon"
                            )
                        },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "show key icon",
                                tint = tintColor,
                                modifier = Modifier.clickable {
                                    isKeyVisible = !isKeyVisible
                                    tintColor = if(tintColor == Color.Blue) Color.Black else Color.Blue
                                }
                            )
                        },
                        visualTransformation = if(isKeyVisible) VisualTransformation.None else PasswordVisualTransformation()
                    )

                    // new line
                    Spacer(modifier = Modifier.size(15.dp))

                    // Proceed Button
                    Button(
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue,
                            contentColor = Color.White,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.DarkGray
                        ),
                        enabled = enableState,
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 15.dp,
                            hoveredElevation = 10.dp,
                            pressedElevation = 5.dp,
                            disabledElevation = 0.dp
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .padding(horizontal = 20.dp),
                        onClick = {
                            enableState = !enableState
                            cardContentBody = if(keyTextState.isNotEmpty()) keyTextState else "This is the main background of our upcoming android project. It is going to be developed in Kotlin. Also we are using latest jetpack compose for the UI instead of old traditional XML."
                        }

                    ) {
                        Text(text = stringResource(id = R.string.proceed_button))
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
private fun AnnotatedString.Builder.blueGradientText(text: String) {
    withStyle(
        style = SpanStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFF2788C7),
                    Color(0xFF00BBD4),
                    Color(0xFF2788C7),
                    Color(0xFF00BBD4),
                )
            ),
            fontFamily = LatoFont,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
    ) {
        append(text)
    }
}

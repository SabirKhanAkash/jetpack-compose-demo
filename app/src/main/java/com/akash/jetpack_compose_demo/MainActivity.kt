@file:OptIn(ExperimentalMaterial3Api::class)

package com.akash.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
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
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
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

                    val annotatedString = buildAnnotatedString {
                        blueGradientText(stringResource(id = R.string.gradient_text))
                    }

                    Text(text = annotatedString)

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
                            text = stringResource(id = R.string.card_content_text),
                            author = Author(
                                name = stringResource(id = R.string.card_content_author_name),
                                job = stringResource(id = R.string.card_content_author_job_title),
                                image = R.drawable.app_logo
                            )
                        )
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

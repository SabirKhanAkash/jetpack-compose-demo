package com.akash.jetpack_compose_demo.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akash.jetpack_compose_demo.ui.theme.LatoFont

data class Author(
    val name: String,
    @DrawableRes val image: Int,
    val job: String
)

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    title: String,
    text: String,
    author: Author
) {
    var showFullText by rememberSaveable {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier.animateContentSize(),
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        // Parent Body
        Column {
            // Top Image
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                painter = painterResource(id = image),
                contentDescription = "image",
                contentScale = ContentScale.Crop
            )
            // Content Body
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Header Text
                Text(
                    text = title,
                    color = Color.White,
                    fontSize = 22.sp,
                    fontFamily = LatoFont,
                    fontWeight = FontWeight.Medium
                )

                // new line
                Spacer(modifier = Modifier.size(25.dp))

                // Body Text
                Text(
                    text = text,
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 24.sp,
                    fontFamily = LatoFont,
                    maxLines = if (showFullText) 100 else 3,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.clickable {
                        showFullText = !showFullText
                    }
                )

                // new line
                Spacer(modifier = Modifier.size(25.dp))

                // Author Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    // Author Image
                    Image(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = author.image),
                        contentDescription = "Author image"
                    )

                    // horizontal spacing
                    Spacer(modifier = Modifier.size(15.dp))

                    // Author Body
                    Column {
                        // Author Name
                        Text(
                            text = author.name,
                            color = Color.White,
                            fontSize = 17.sp,
                            fontFamily = LatoFont,
                            fontWeight = FontWeight.Medium
                        )

                        // new line
                        Spacer(modifier = Modifier.size(5.dp))

                        // Author Job title
                        Text(
                            text = author.job,
                            color = Color.White,
                            fontSize = 15.sp,
                            fontFamily = LatoFont,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}
package com.akash.jetpack_compose_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akash.jetpack_compose_demo.ui.theme.JetpackcomposedemoTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    app()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun app() {
    /**
     * Background Image
     */
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_background),
            contentDescription = "background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }
    /**
     *Language Changer
     */
    Row(
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "English (US)",
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }
    /**
     *App Logo
     */
    Row(
        modifier = Modifier
            .wrapContentSize(Alignment.TopCenter)
            .padding(top = 120.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = "app logo",
            modifier = Modifier
                .size(150.dp)
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        )
    }
    /**
     * Username TextField
     */
    Row(
        modifier = Modifier
            .padding(20.dp, 300.dp, 20.dp, 0.dp)
            .fillMaxWidth(),
    ) {
        var username by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White.copy(alpha = 0.8f),
                unfocusedLabelColor = Color.White.copy(alpha = 0.8f),
                focusedLabelColor = Color.White.copy(alpha = 0.8f),
                cursorColor = Color.White
            ),
            label = { Text("Employee ID")},
            modifier = Modifier
                .fillMaxWidth()
        )
    }
    /**
     * Password TextField
     */
    Row(
        modifier = Modifier.padding(20.dp,380.dp,20.dp,0.dp),
    ) {
        var password by rememberSaveable {
            mutableStateOf("")
        }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White.copy(alpha = 0.8f),
                unfocusedLabelColor = Color.White.copy(alpha = 0.8f),
                focusedLabelColor = Color.White.copy(alpha = 0.8f),
                cursorColor = Color.White
            ),
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle(color = Color.White),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth()
        )
    }
    /**
     * Login Button
     */
    Row(
        modifier = Modifier
            .padding(top = 470.dp)
            .wrapContentSize(Alignment.TopCenter)
            .fillMaxWidth()
    ) {
        Button(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()
                .height(45.dp),
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(size = 8.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Blue
            )
        ) {
            Text(text = "LOG IN")
        }
    }
    /**
     *App Footer
     */
    Row(
        modifier = Modifier
            .padding(bottom = 10.dp)
            .wrapContentSize(Alignment.BottomCenter)
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_footer),
            contentDescription = "footer",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(80.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun appPreview() {
    MaterialTheme {
        app()
    }
}
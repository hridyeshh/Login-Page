package com.example.loginpage

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme
import com.example.loginpage.ui.theme.new

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                page()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun page(){
    val context = LocalContext.current
    var username by remember {
        mutableStateOf(TextFieldValue(""))
    }
    var password by remember {
        mutableStateOf(TextFieldValue(""))
    }
    

    Column(
        Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(listOf(Color.Black, Color.Gray)))
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(
                id = R.mipmap.google_foreground
            ),
            contentDescription = "Logo",
            modifier = Modifier
                .padding(10.dp)
        )
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = { Text(text = "Username") },
            modifier = Modifier.padding(10.dp)
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.padding(10.dp),
        )
        Button(
            onClick = {
                Log.d("AAA", "${username.text}")
                Log.d("AAA", "${password.text}")
                if (username.text == "Vaibhav" || username.text == "vaibhav" && password.text == "founder") {
                    Toast.makeText(
                        context,
                        "Happy birthday to you Vaibhav!!", Toast.LENGTH_LONG
                    )
                        .show()
                } else {
                    Toast.makeText(context, "Try again bro!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text(text = "Log in")
        }
        Card(modifier = Modifier
            .padding(10.dp)
        ) {
            Text(text = "-----------------------OR-----------------------")
        }
        Button(onClick = { }) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Login with Google",
                    textAlign = TextAlign.Center
                )
                Image(painter = painterResource(id = R.mipmap.google_foreground),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(25.dp)
                        .padding(4.dp),
                    alignment = Alignment.Center
                )

            }
        }
    }
}

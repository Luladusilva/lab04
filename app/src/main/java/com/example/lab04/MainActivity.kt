package com.example.lab04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab04.ui.theme.Lab04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab04Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LittleFormWithFooter()
                }
            }
        }
    }
}

@Composable
fun LittleFormWithFooter() {
    // Estado para guardar el nombre y el saludo
    var name by remember { mutableStateOf("") }
    var greeting by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            if (greeting.isNotEmpty()) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = greeting,
                        modifier = Modifier.padding(16.dp),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(56.dp))

            Text(
                text = "Welcome space-traveler!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(56.dp))
            Text(
                text = "U-R in my space!",
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(86.dp))
            Image(
                painter = painterResource(id = R.drawable.darth),
                contentDescription = "darthVader Image",
                modifier = Modifier.size(120.dp)
            )
            Spacer(modifier = Modifier.height(56.dp))

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Enter your spacial-name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(16.dp),
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { greeting = "Welcome aboard, $name! 🚀" },
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, Color.Black),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFEEEEEE),
                    contentColor = Color.Black,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.DarkGray,
                )
            ) {
                Text("Lift Off!")
            }
            Spacer(modifier = Modifier.height(180.dp))

            Text(
                text = "Powered by BlackDragon",
                fontSize = 15.sp,
                style = MaterialTheme.typography.titleLarge, // 👈 estilo predefinido del tema
                color = Color.Gray,           // color personalizado
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

fun ViewHolaCurso() {
    Column(
        modifier = Modifier
            .fillMaxWith()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to the Course!",
            fontSize = 28.sp,
            fontWeight = FontWeigh.Bold
        )
        Spacer(modifier = Modifier.heigh(16.dp))
        Text(
            text = "Hello, Student!",
            fontSize = 20.sp

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLittleFormWithFooter() {
    LittleFormWithFooter()
}

package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 104.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleImage()
        Text(text = "Chat App")
        Row {
            Button(onClick = {  }) {
                Text("Login")
            }
            Spacer(modifier = Modifier.width(24.dp))
            Button(onClick = {  }) {
                Text("Register")
            }
        }
    }
}

@Composable
fun TitleImage(modifier: Modifier = Modifier) {
    Image(
        painterResource("img/chat-logo.jpeg"),
        contentDescription = null,
        modifier = modifier
            .size(184.dp)
    )
}
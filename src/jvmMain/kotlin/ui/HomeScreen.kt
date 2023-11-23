package ui

import ChatViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MainScreen() {

    val viewModel: ChatViewModel = ChatViewModel()

    var username: String by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 104.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleImage()
        Text(text = "Chat App", modifier = Modifier.padding(8.dp))
        TextField(value = username, onValueChange = {
            username = it
        })
        Button(onClick = {
            if(username.length < 1) username = viewModel.getRandomUsername()
        }) {
            Text("Connect")
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
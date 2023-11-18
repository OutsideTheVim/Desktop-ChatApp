package ui.hub

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import models.Message

@Composable
fun VerifyDash() { // later voor login check
    Dash()
}

@Composable
fun Dash() {

    var allMessages by remember {
        mutableStateOf(
            mutableListOf(
                Message(message = "Hoe gaat het?", outgoing = true),
                Message(message = "Heel slecht!", outgoing = false),
                Message(message = "Waarom??", outgoing = true),
                Message(message = "Nee grapje! hahaha", outgoing = false),
                Message(message = "haha", outgoing = true),
                Message(message = "nog een fijne dag verder!", outgoing = false)
            )
        )
    }

    var textInput by remember { mutableStateOf("") }


    Row {
        LazyColumn(Modifier.background(Color(0xFF436ccc)).fillMaxHeight()) {
            items(8) {
                LeftBar(
                    "Nathan",
                    "Online",
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, bottom = 6.dp, top = 6.dp)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF5688fc))
        ) {
            LazyColumn {
                items(allMessages) {
                    var modifier: Modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.End)
                        .padding(top = 16.dp, end = 44.dp)

                    if (it.outgoing) modifier = Modifier
                        .padding(top = 16.dp, start = 44.dp)

                    MessageCard(
                        message = it.message,
                        modifier = modifier
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 44.dp)
            ) {
                TextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    modifier = Modifier
                        .background(Color.Gray)
                )
                Spacer(Modifier.width(12.dp))
                Button(onClick = { // werkt nog niet correct
                    allMessages.add(Message(message = textInput, outgoing = true))
                    textInput = ""
                }) {
                    Text("Send")
                }
            }
        }
    }
}

@Composable
fun MessageCard(
    message: String,
    outgoing: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.clip(RoundedCornerShape(24.dp))) {
        Text(
            text = message,
            modifier = Modifier
                .padding(8.dp)
        )
    }
}

@Composable
fun LeftBar(
    friendName: String,
    friendStatus: String,
    unreadMessage: Boolean = false,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.width(174.dp)
    ) {
        Column(modifier = Modifier.background(Color(0XFF3256a8))) {
            Text(
                text = friendName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = friendStatus,
                fontSize = 18.sp
            )
        }
    }
}
package com.example.month6w1_geeks

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.m6lesson1.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserInfo()
        }
    }

    @Composable
    fun UserInfo() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row {
                CircleImage(100)
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    BoldBigText("Sasuke Uchiha")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Canvas(
                            modifier = Modifier
                                .wrapContentSize()
                                .clip(CircleShape)
                                .size(12.dp)
                        ) {
                            drawRect(
                                color = Color.Green,
                            )
                        }
                        Text(
                            modifier = Modifier.padding(horizontal = 6.dp),
                            fontSize = 20.sp,
                            text = "online"
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            BoldBigText("About me")
            Spacer(modifier = Modifier.height(12.dp))
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    fontSize = 16.sp,
                    color = Color.Gray,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Light,
                    text = "Sasuke Uchiha, Naruto's main rival, is one of its primary and most popular characters. Thanks to the number of fans of both the character and the series, Sasuke has become a popular synonym for “ninja.” The name Sasuke itself means “assistant” or “help” in Japanese."
                )
                Button(modifier = Modifier.padding(top = 12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    onClick = {
                        Toast.makeText(this@MainActivity, "This feature is not yet available", Toast.LENGTH_SHORT).show()
                    }) {
                    Text(text = "Edit", color = Color.Magenta)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Column {
                HobbiesList(R.drawable.ic_paw, "Anime")
                HobbiesList(R.drawable.ic_seal, "\n" + "Element")
                HobbiesList(R.drawable.ic_studying, "Unit type")
            }
        }
    }

    @Composable
    fun CircleImage(height: Int){
        Image(
            modifier = Modifier
                .size(height.dp)
                .clip(CircleShape)
                .border(BorderStroke(1.dp, Color.Blue), shape = CircleShape),
            painter = painterResource(R.drawable.saske),
            contentDescription = "User profile photo"
        )
    }

    @Composable
    fun HobbiesList(id: Int, text: String) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(modifier = Modifier
                .size(24.dp)
                .padding(end = 8.dp),
                painter = painterResource(id),
                contentDescription = ""
            )
            Text(
                fontStyle = FontStyle.Italic,
                fontSize = 16.sp,
                text = text
            )
        }
    }

    @Composable
    fun BoldBigText(text:String){
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            text = text
        )
    }

    @Preview
    @Composable
    fun UserInfoPreview() {
        UserInfo()
    }
}


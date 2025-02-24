package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.`bg`),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.`coolicon`),
                contentDescription = "Android Logo",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Robert Janairo", fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.Green)
            Text("Software Developer", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = Color.Green)
            Spacer(modifier = Modifier.height(24.dp))
            ContactInfo()
        }
    }
}

@Composable
fun ContactInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 16.dp)) {
        ContactRow(R.drawable.`phone`, "+1 (587) 830 4985")
        ContactRow(R.drawable.`share`, "@RobertJanairo")
        ContactRow(R.drawable.`email`, "pasionrobert7@gmail.com")
    }
}

@Composable
fun ContactRow(iconId: Int, text: String) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(id = iconId), contentDescription = null, tint = Color.Cyan, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text(text, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}

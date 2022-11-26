package com.example.namecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Icon
import androidx.compose.material.icons.materialIcon
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NameCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NameCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var firstName: String = stringResource(id = R.string.first_name_ryoma)
                    var familyName: String = stringResource(id = R.string.family_name_kubo)
                    var profileImage: Painter = painterResource(id = R.drawable.android_logo)
                    var profession: String = stringResource(id = R.string.profession)

                    Column(
                        modifier = Modifier,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(modifier = Modifier.height(140.dp))
                        outProfile(familyName, firstName, profileImage, profession)
                        Spacer(modifier = Modifier.height(16.dp))
                        // 詳細情報ボタン
                        Button()
                    }

                }
            }
        }
    }
}

@Composable
fun outProfile(familyName: String, firstName: String, profileImage: Painter, profession: String){
    // イメージ画像
    Image(
        painter = profileImage,
        contentDescription = "顔写真",
        Modifier
            .height(100.dp)
            .width(100.dp)
    )
    // 名前
    Text(
        text = "${familyName} ${firstName}",
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    // 職業
    Text(
        text = profession,
        color = Color.LightGray,
        fontSize = 12.sp
    )
}

@Composable
fun Button(){
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)
    ) {
        materialIcon(name = "詳細情報",)
        Text(text = "詳細情報",
            color = Color.White)
    }
    
}

package com.example.namecard

import android.graphics.drawable.Icon
import android.location.Address
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.namecard.ui.theme.NameCardTheme
import org.w3c.dom.Text

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
//                    var firstName: String = stringResource(id = R.string.first_name_ryoma)
//                    var familyName: String = stringResource(id = R.string.family_name_kubo)
//                    var profileImage: Painter = painterResource(id = R.drawable.android_logo)
//                    var profession: String = stringResource(id = R.string.profession)
//                    var mailAddress: String = stringResource(id = R.string.email_address)
//                    var phoneNumber: String = stringResource(id = R.string.phone_number)
//                    var twitterId: String = stringResource(id = R.string.twitter_id)
//                    var myAddress: String = stringResource(id = R.string.my_address)
//                    var myHobby: String = stringResource(id = R.string.my_hobby)

                    var firstName: String = stringResource(id = R.string.initialize)
                    var familyName: String = stringResource(id = R.string.initialize)
                    var profileImage: Painter = painterResource(id = R.drawable.android_logo)
                    var profession: String = stringResource(id = R.string.initialize)
                    var mailAddress: String = stringResource(id = R.string.initialize)
                    var phoneNumber: String = stringResource(id = R.string.initialize)
                    var twitterId: String = stringResource(id = R.string.initialize)
                    var myAddress: String = stringResource(id = R.string.initialize)
                    var myHobby: String = stringResource(id = R.string.initialize)

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Spacer(modifier = Modifier.height(140.dp))
                        // プロフィール情報
                        outProfile(familyName, firstName, profileImage, profession)
                        Spacer(modifier = Modifier.height(47.dp))
                        // 詳細情報ボタン
                        if (Button()) {
                            Spacer(modifier = Modifier.height(47.dp))
                            iconIn(mailAddress, Icons.Default.Email)
                            iconIn(phoneNumber, Icons.Default.Phone)
                            iconIn(twitterId, Icons.Default.CheckCircle)
                            iconIn(myAddress, Icons.Default.Home)
                            iconIn(myHobby, Icons.Default.Favorite)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun outProfile(familyName: String, firstName: String, profileImage: Painter, profession: String) {
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
        fontSize = 20.sp
    )
    Spacer(modifier = Modifier.height(16.dp))
    // 職業
    Text(
        text = profession,
        color = Color.LightGray,
        fontSize = 16.sp
    )
}

@Composable
fun iconIn(label: String, icon: ImageVector) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
    ) {
        Spacer(modifier = Modifier.height(65.dp))
        Spacer(modifier = Modifier.width(100.dp))
        Icon(imageVector = icon, contentDescription = "E-mail")
        Spacer(modifier = Modifier.width(20.dp))

        Text(text = label)
    }

}

@Composable
fun Button(): Boolean {
    var buttonFlg  by remember { mutableStateOf(false)}

    Button(
        onClick = { buttonFlg = !buttonFlg },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray)

    ) {
        Text(
            text = "詳細情報",
            color = Color.White,
            fontSize = 20.sp
        )
    }
    return buttonFlg
}

package com.andrograf.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andrograf.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Card()
                }
            }
        }
    }
}

@Composable
fun Profile(modifier: Modifier){
    var image = painterResource(id = R.drawable.profile)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = image,
            contentDescription = stringResource(R.string.Name),
        )
        Text(
            text = stringResource(R.string.Name),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            modifier = modifier.padding(10.dp)
        )
        Text(text = stringResource(R.string.title))
    }
}

@Composable
fun ContactInfo(
    modifier: Modifier,
    icon: Icons.Rounded = Icons.Rounded){

    Column (
       // horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
            ) {
        Contact(
            icon.Phone,
            contentDescription = stringResource(R.string.mobile_number),
            contactInfo = stringResource(R.string.example_number),
            modifier
        )
        Contact(
            icon.Email,
            contentDescription = stringResource(R.string.email_address),
            contactInfo = stringResource(R.string.example_email),
            modifier
        )
        Contact(
            icon.Person,
            contentDescription = stringResource(R.string.linkedin_name),
            contactInfo = stringResource(R.string.example_linkedin_name),
            modifier
        )
    }
}

@Composable
fun Contact(
    imageVector: ImageVector,
    contentDescription: String,
    contactInfo: String,
    modifier: Modifier){

    Row (
        modifier = modifier.padding(5.dp)
            ) {
        Icon(
            imageVector,
            contentDescription = contentDescription
        )
        Text(
            text = contactInfo,
            modifier = modifier.padding( 15.dp, 0.dp, 0.dp, 0.dp)
        )
    }

}

@Composable
fun Card(modifier: Modifier = Modifier){
    Column (
        modifier = modifier.padding(16.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
            ) {
        Profile(modifier = modifier)
        ContactInfo(modifier = modifier)
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Business Card"
)
@Composable
fun Preview() {
    BusinessCardTheme {
        Card()
    }
}
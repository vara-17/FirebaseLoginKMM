package ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.firebase.model.FirebaseManager
import domain.navigation.NavigationManager
import kotlinx.coroutines.launch
import res.BackgroundColor
import ui.components.button.LoginButton
import ui.components.text.ForgotPassword
import ui.components.textfield.Email
import ui.components.textfield.Password

@Composable
fun LoginView() {
    Box(Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            Modifier.fillMaxSize().padding(12.dp)
        ) {
            LogoView(Modifier.align(Alignment.TopCenter))
            BodyView(Modifier.align(Alignment.Center))
            FooterView(Modifier.align(Alignment.BottomCenter))
        }

    }
}

@Composable
fun LogoView(modifier: Modifier) {
    Text(
        text = "NameApp",
        fontSize = 50.sp,
        color = Color.White,
        modifier = modifier.padding(vertical = 100.dp),
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun BodyView(modifier: Modifier) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var isLoginEnabled by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) { password = it }
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(modifier = Modifier.size(16.dp))
        LoginButton(email, password)
        //Spacer(modifier = Modifier.size(16.dp))
        //GoogleLogin()
    }
}

@Composable
fun FooterView(modifier: Modifier) {
    val composableScope = rememberCoroutineScope()
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(modifier = Modifier.background(Color.White).height(1.dp).fillMaxWidth())
        Spacer(modifier = Modifier.size(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Don't have an account?",
                fontSize = 12.sp,
                color = Color.White
            )
            Text(
                text = "Sign up.",
                modifier = Modifier.padding(horizontal = 8.dp).clickable {
                    composableScope.launch {
                        FirebaseManager.signOut()
                        NavigationManager.setShowSignUpView(true)
                    }
                },
                fontSize = 12.sp,
                color = Color(0xFF4EA8E9)
            )
        }
    }
}
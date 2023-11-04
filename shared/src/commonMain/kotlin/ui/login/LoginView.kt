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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.firebase.model.FirebaseManager
import domain.navigation.NavigationManager
import kotlinx.coroutines.launch
import res.*
import ui.components.button.LoginButton
import ui.components.custom.GoogleLogin
import ui.components.custom.Spacer16
import ui.components.custom.Spacer4
import ui.components.custom.Spacer8
import ui.components.images.LogoImage
import ui.components.text.ForgotPasswordTextButton
import ui.components.textfield.Email
import ui.components.textfield.Password

@Composable
fun LoginView() {
    Box(Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            Modifier.fillMaxSize().padding(ViewGeneralPadding())
        ) {
            Column {
                LogoImage()
                BodyView()
            }
            FooterView(Modifier.align(Alignment.BottomCenter))
        }

    }
}

@Composable
fun BodyView() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column() {
        Email(email) { email = it }
        Spacer4()
        Password(password) { password = it }
        Spacer8()
        ForgotPasswordTextButton(Modifier.align(Alignment.End))
        Spacer16()
        LoginButton(email, password)
        //Spacer16()
        //GoogleLogin()
    }
}

@Composable
fun FooterView(modifier: Modifier) {
    val composableScope = rememberCoroutineScope()
    Column(modifier = modifier.fillMaxWidth()) {
        Divider(modifier = Modifier.background(Color.White).height(1.dp).fillMaxWidth())
        Spacer8()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = StringTexts.notAccount,
                style = SimpleTextStyle()
            )
            Text(
                text = StringTexts.signUp,
                modifier = Modifier.padding(horizontal = 8.dp).clickable {
                    composableScope.launch {
                        FirebaseManager.signOut()
                        NavigationManager.setShowSignUpView(true)
                    }
                },
                style = TextButtonStyle()
            )
        }
    }
}
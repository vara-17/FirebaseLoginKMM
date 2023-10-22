package ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.firebase.model.LoginWithEmail
import domain.navigation.NavigationManager
import res.BackgroundColor
import res.LoginTextStyle
import ui.components.button.RegisterButton
import ui.components.cards.SignUpResult
import ui.components.custom.Spinner
import ui.components.textfield.Email
import ui.components.textfield.Password

@Composable
fun SignUpEmailAndPasswordView() {
    var loginModel: LoginWithEmail by remember { mutableStateOf(LoginWithEmail.Success) }
    var showPopUp: Boolean by remember { mutableStateOf(loginModel.showPopUp) }
    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            Modifier.fillMaxSize().padding(12.dp)
        ) {
            SignUpTopView(Modifier.align(Alignment.TopEnd))
            SignUpBodyView(Modifier.align(Alignment.Center)) {
                loginModel = it
                showPopUp = loginModel.showPopUp
            }
        }
        SignUpResult(loginModel, showPopUp) {
            loginModel.showPopUp = false
            showPopUp = loginModel.showPopUp
        }
    }
}


@Composable
fun SignUpTopView(modifier: Modifier) {
    IconButton(modifier = modifier.size(24.dp),
        onClick = { NavigationManager.setShowSignUpView(false) }) {
        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
    }
}

@Composable
fun SignUpBodyView(modifier: Modifier, loginModel: (LoginWithEmail) -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }
    var showSpinner by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier) {
        Text(
            text = "Registrar nuevo usuario",
            style = LoginTextStyle(),
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        Password(password) { password = it }
        Spacer(modifier = Modifier.size(4.dp))
        Password(confirmPassword, "Confirm password") { confirmPassword = it }
        Spacer(modifier = Modifier.size(8.dp))
        RegisterButton(email, password, confirmPassword, loginModel) { showSpinner = it }
    }
    Spinner(showSpinner)
}

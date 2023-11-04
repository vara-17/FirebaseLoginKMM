package ui.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.firebase.model.RememberPassword
import domain.navigation.NavigationManager
import res.*
import ui.components.button.RememberButton
import ui.components.cards.RememberPasswordResult
import ui.components.custom.Spacer4
import ui.components.custom.Spinner
import ui.components.images.LoginCloseButtonIcon
import ui.components.images.LogoImage
import ui.components.text.RememberPasswordInfo
import ui.components.textfield.Email

@Composable
fun RememberPasswordView() {
    var rememberModel: RememberPassword by remember { mutableStateOf(RememberPassword.Success) }
    var showPopUp: Boolean by remember { mutableStateOf(rememberModel.showPopUp) }
    var showSpinner by rememberSaveable { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            modifier = Modifier.fillMaxSize().padding(ViewGeneralPadding())
        ) {
            RememberTopView(Modifier.align(Alignment.TopEnd))
            RememberBodyView(
                rememberModel = {
                    rememberModel = it
                    showPopUp = rememberModel.showPopUp
                },
                showSpinner = { showSpinner = it })
        }
        Spinner(showSpinner)
        RememberPasswordResult(rememberModel, showPopUp) {
            rememberModel.showPopUp = false
            showPopUp = rememberModel.showPopUp
        }
    }
}

@Composable
fun RememberBodyView(rememberModel: (RememberPassword) -> Unit, showSpinner: (Boolean) -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth()) {
        LogoImage()
        RememberPasswordInfo()
        Spacer4()
        Email(email) { email = it }
        Spacer4()
        RememberButton(email, rememberModel, showSpinner)
    }
}

@Composable
fun RememberTopView(modifier: Modifier) {
    LoginCloseButtonIcon(modifier.size(CloseButtonSize())) {
        NavigationManager.setShowRememberPassword(false)
    }
}

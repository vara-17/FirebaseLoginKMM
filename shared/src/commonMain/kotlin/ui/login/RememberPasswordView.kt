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
import res.BackgroundColor
import ui.components.button.RememberButton
import ui.components.cards.RememberPasswordResult
import ui.components.custom.Spinner
import ui.components.text.RememberPasswordInfo
import ui.components.textfield.Email

@Composable
fun RememberPasswordView() {
    var rememberModel: RememberPassword by remember { mutableStateOf(RememberPassword.Success) }
    var showPopUp: Boolean by remember { mutableStateOf(rememberModel.showPopUp) }
    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            Modifier.fillMaxSize().padding(12.dp)
        ) {
            RememberTopView(Modifier.align(Alignment.TopEnd))
            RememberBodyView(Modifier.align(Alignment.Center)) {
                rememberModel = it
                showPopUp = rememberModel.showPopUp
            }
        }
        RememberPasswordResult(rememberModel, showPopUp) {
            rememberModel.showPopUp = false
            showPopUp = rememberModel.showPopUp
        }
    }
}

@Composable
fun RememberBodyView(modifier: Modifier, rememberModel: (RememberPassword) -> Unit) {
    var email by rememberSaveable { mutableStateOf("") }
    var showSpinner by rememberSaveable { mutableStateOf(false) }
    Column(modifier = modifier.fillMaxWidth()) {
        RememberPasswordInfo()
        Spacer(modifier = Modifier.size(4.dp))
        Email(email) { email = it }
        Spacer(modifier = Modifier.size(4.dp))
        RememberButton(email, rememberModel) { showSpinner = it }
    }
    Spinner(showSpinner)
}

@Composable
fun RememberTopView(modifier: Modifier) {
    IconButton(
        modifier = modifier.size(24.dp),
        onClick = { NavigationManager.setShowRememberPassword(false) }) {
        Icon(imageVector = Icons.Filled.Close, contentDescription = "Close", tint = Color.White)
    }
}

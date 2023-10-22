package ui.login

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import data.firebase.model.FirebaseManager
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import res.BackgroundColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun UserLoggedView() {
    val composableScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize().background(BackgroundColor())) {
        Box(
            Modifier.fillMaxSize().padding(12.dp)
        ) {
            Text(
                text = "User logged in!\n\n\n\n\n",
                modifier = Modifier.align(Alignment.Center),
                color = Color.White
            )
            Button(onClick = {
                composableScope.launch { FirebaseManager.signOut() }
            }, modifier = Modifier.align(Alignment.Center)) {
                Text(text = "Log out")
            }
        }
    }
}
package ui.components.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import res.ImagesPaths
import res.LoginTextStyle


@OptIn(ExperimentalResourceApi::class)
@Composable
fun GoogleLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(ImagesPaths.googleImage),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Spacer4()
        Text(text = "Sign in with Google account", style = LoginTextStyle())
    }
}
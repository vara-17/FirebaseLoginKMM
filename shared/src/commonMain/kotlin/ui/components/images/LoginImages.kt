package ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import domain.navigation.NavigationManager
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import res.*

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogoImage() {
    Image(
        painter = painterResource(ImagesPaths.loginViewImage),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().size(LoginViewIconSize()).padding(vertical = LoginViewIconPaddingSize()),
        colorFilter = ColorFilter.tint(color = LoguinIconColor())
    )
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LoginPopUpImage(image: String) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        modifier = Modifier.size(36.dp),
        colorFilter = ColorFilter.tint(color = LoguinPopUpIconColor())
    )
}

@Composable
fun LoginCloseButtonIcon(modifier: Modifier, onCloseClick: () -> Unit){
    IconButton(modifier = modifier.size(CloseButtonSize()),
        onClick = { onCloseClick() }) {
        LoginCloseIcon()
    }
}
@Composable
fun LoginCloseIcon(){
    Icon(imageVector = Icons.Filled.Close, contentDescription = null, tint = LoguinCloseIconColor())
}
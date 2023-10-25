package ui.components.images

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import res.ImagesPaths
import res.LoguinIconColor
import res.LoguinPopUpIconColor

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LogoImage() {
    Image(
        painter = painterResource(ImagesPaths.loginViewImage),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth().size(300.dp).padding(vertical = 50.dp),
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
package ui.components.text

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import domain.navigation.NavigationManager
import res.InfoTextStyle
import res.StringTexts
import res.TextButtonStyle

@Composable
fun ForgotPasswordTextButton(modifier: Modifier) {
    Text(
        text = StringTexts.forgotPassword,
        modifier = modifier.clickable { NavigationManager.setShowRememberPassword(true) },
        style = TextButtonStyle()
    )
}

@Composable
fun RememberPasswordInfo(){
    Text(
        text = StringTexts.forgotPasswordInfo,
        modifier = Modifier.fillMaxWidth(),
        style = InfoTextStyle()
    )
}
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

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        modifier = modifier.clickable { NavigationManager.setShowRememberPassword(true) },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9)
    )
}

@Composable
fun RememberPasswordInfo(){
    Text(
        text = "Introduce el email de tu cuenta. Te enviaremos un correo para recuperar la contraseña.",
        modifier = Modifier.fillMaxWidth(),
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = Color.White
    )
}
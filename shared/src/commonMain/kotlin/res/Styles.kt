package res

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun LoginTextStyle(): TextStyle {
    return TextStyle(
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )
}
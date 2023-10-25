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

/*
 * Texts
 */
@Composable
fun SimpleTextStyle(): TextStyle{
    return TextStyle(
        color = SimpleTextColor(),
        fontSize = 12.sp
    )
}

@Composable
fun TextButtonStyle(): TextStyle{
    return TextStyle(
        color = TextButtonColor(),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )
}

@Composable
fun ButtonTextStyle(): TextStyle{
    return TextStyle(
        color = ButtonTextColor(),
        fontSize = 16.sp
    )
}
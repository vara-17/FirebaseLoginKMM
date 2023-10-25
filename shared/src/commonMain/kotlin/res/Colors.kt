package res

import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BackgroundColor(): Color {
    return Color(0xBB000000)
}

fun SpinnerBackgroundColor2(): Color{
    return Color(0xAA000000)
}


/*
 * Views
 */
fun BackgroundViewColor(): Color{
    return Color(0XBB000000)
}

/*
 * Icon tint
 */
fun LoguinIconColor(): Color{
    return Color.White
}

fun LoguinPopUpIconColor(): Color{
    return Color.Black
}

/*
 * Text
 */
fun SimpleTextColor(): Color{
    return Color.White
}

/*
 * Buttons
 */
@Composable
fun ButtonBackgroundColor(): ButtonColors {
    return ButtonDefaults.buttonColors(backgroundColor = Color(0xFFE4D8B4))
}

fun TextButtonColor(): Color{
    return Color(0xFF4EA8E9)
}

fun ButtonTextColor(): Color{
    return Color.White
}

/*
 * Spinner
 */
fun SpinnerBackgroundColor(): Color{
    return Color.Black
}

fun SpinnerProgressColor(): Color{
    return Color(0xFF0DBBBF)
}

fun SpinnerBackgroundViewColor(): Color{
    return Color(0x33000000)
}

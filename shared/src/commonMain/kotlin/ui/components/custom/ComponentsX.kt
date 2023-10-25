package ui.components.custom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/*
 * Spacer
 */
@Composable
fun SpacerX(size: Dp) {
    Spacer(modifier = Modifier.size(size))
}

@Composable
fun Spacer4(){
    SpacerX(4.dp)
}

@Composable
fun Spacer8(){
    SpacerX(8.dp)
}

@Composable
fun Spacer12(){
    SpacerX(12.dp)
}

@Composable
fun Spacer16(){
    SpacerX(16.dp)
}
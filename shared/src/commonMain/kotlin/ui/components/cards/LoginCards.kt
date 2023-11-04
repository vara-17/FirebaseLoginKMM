package ui.components.cards

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.firebase.model.FirebaseManager
import data.firebase.model.LoginWithEmail
import data.firebase.model.RememberPassword
import domain.navigation.NavigationManager
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import res.ImagesPaths
import res.StringTexts
import ui.components.custom.Spacer12
import ui.components.images.LoginPopUpImage


@OptIn(ExperimentalResourceApi::class)
@Composable
fun RememberPasswordResult(model: RememberPassword, show: Boolean, closePopUp: () -> Unit) {
    val composableScope = rememberCoroutineScope()
    val customAnimationSpec: FiniteAnimationSpec<IntOffset> = tween(
        durationMillis = 1000,
        delayMillis = 0
    )
    AnimatedVisibility(
        visible = show,
        enter = slideInVertically(initialOffsetY = { it / 2 }, animationSpec = customAnimationSpec),
        exit = slideOutVertically(targetOffsetY = { it / 2 }, animationSpec = customAnimationSpec)
    ) {
        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).pointerInput(Unit) {
            detectTapGestures {
                if (!(model is RememberPassword.Success)) closePopUp()
            }
        }) {
            Card(elevation = 12.dp,
                backgroundColor = Color.White,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 32.dp)
                    .defaultMinSize(Dp.Unspecified, 150.dp)
                    .background(Color.White).pointerInput(Unit) { detectTapGestures {} }) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginPopUpImage(getRememberPasswordResultIcon(model))
                    Spacer12()
                    Text(text = model.text, color = Color.Black)
                    Spacer12()
                    Text(
                        text = getRememberPasswordResultTextButton(model),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4EA8E9),
                        modifier = Modifier.clickable(interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                if (model is RememberPassword.Success) {
                                    composableScope.launch {
                                        FirebaseManager.signOut()
                                    }
                                    NavigationManager.setShowRememberPassword(false)
                                }
                                closePopUp()
                            })
                    )
                }
            }
        }
    }
}

private fun getRememberPasswordResultIcon(model: RememberPassword): String {
    return when (model) {
        RememberPassword.Success -> ImagesPaths.ic_send_email
        else -> ImagesPaths.ic_error
    }
}

private fun getRememberPasswordResultTextButton(model: RememberPassword): String {
    return when (model) {
        RememberPassword.Success -> StringTexts.back
        else -> StringTexts.tryAgain
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun SignUpResult(model: LoginWithEmail, show: Boolean, closePopUp: () -> Unit) {
    val composableScope = rememberCoroutineScope()
    val customAnimationSpec: FiniteAnimationSpec<IntOffset> = tween(
        durationMillis = 1000,
        delayMillis = 0
    )
    AnimatedVisibility(
        visible = show,
        enter = slideInVertically(initialOffsetY = { it / 2 }, animationSpec = customAnimationSpec),
        exit = slideOutVertically(targetOffsetY = { it / 2 }, animationSpec = customAnimationSpec)
    ) {
        Box(modifier = Modifier.fillMaxSize().background(Color.Transparent).pointerInput(Unit) {
            detectTapGestures {
                if (!(model is LoginWithEmail.Success)) closePopUp()
            }
        }) {
            Card(elevation = 12.dp,
                backgroundColor = Color.White,
                shape = MaterialTheme.shapes.small,
                modifier = Modifier.align(Alignment.BottomCenter).fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 32.dp)
                    .defaultMinSize(Dp.Unspecified, 150.dp)
                    .background(Color.White).pointerInput(Unit) { detectTapGestures {} }) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LoginPopUpImage(getSignUpResultIcon(model))
                    Spacer12()
                    Text(text = model.text, color = Color.Black)
                    Spacer12()
                    Text(
                        text = getSignUpResultTextButton(model),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF4EA8E9),
                        modifier = Modifier.clickable(interactionSource = MutableInteractionSource(),
                            indication = null,
                            onClick = {
                                if (model is LoginWithEmail.Success) {
                                    composableScope.launch {
                                        FirebaseManager.signOut()
                                    }
                                    closePopUp()
                                    NavigationManager.setShowSignUpView(false)
                                } else {
                                    closePopUp()
                                }
                            })
                    )
                }
            }
        }
    }
}

private fun getSignUpResultIcon(model: LoginWithEmail): String {
    return when (model) {
        LoginWithEmail.Success -> ImagesPaths.ic_success
        else -> ImagesPaths.ic_error
    }
}

private fun getSignUpResultTextButton(model: LoginWithEmail): String {
    return when (model) {
        LoginWithEmail.Success -> StringTexts.back
        else -> StringTexts.tryAgain
    }
}
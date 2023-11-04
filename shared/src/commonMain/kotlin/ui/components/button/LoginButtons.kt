package ui.components.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import data.firebase.model.FirebaseManager
import data.firebase.model.LoginWithEmail
import data.firebase.model.RememberPassword
import dev.gitlive.firebase.auth.*
import domain.utils.TextUtils
import kotlinx.coroutines.launch
import res.ButtonBackgroundColor
import res.ButtonTextStyle
import res.StringTexts


@Composable
fun LoginButton(email: String, password: String) {
    val composableScope = rememberCoroutineScope()
    Button(
        onClick = {
            composableScope.launch {
                FirebaseManager.signInEmailAndPassword(email, password)
            }
        },
        enabled = TextUtils.checkEmail(email) && TextUtils.checkPassword(password),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonBackgroundColor()
    ) {
        Text(
            text = StringTexts.logIn,
            style = ButtonTextStyle()
        )
    }
}


@Composable
fun RememberButton(
    email: String, rememberModel: (RememberPassword) -> Unit, showSpinner: (Boolean) -> Unit
) {
    val composableScope = rememberCoroutineScope()
    var result: RememberPassword = RememberPassword.Success
    Button(
        onClick = {
            composableScope.launch {
                try {
                    showSpinner(true)
                    FirebaseManager.rememberPassword(email)
                } catch (e: FirebaseAuthException) {
                    when (e) {
                        is FirebaseAuthEmailException -> {
                            result = RememberPassword.InvalidEmail
                        }
                        is FirebaseAuthInvalidCredentialsException -> {
                            result = RememberPassword.InvalidEmail //email malformed
                        }
                        else -> {
                            result = RememberPassword.Unexpected
                        }
                    }
                } finally {
                    result.showPopUp = true
                    showSpinner(false)
                    rememberModel(result)
                }
            }
        }, enabled = TextUtils.checkEmail(email), modifier = Modifier.fillMaxWidth(),
        colors = ButtonBackgroundColor()
    ) {
        Text(
            text = StringTexts.send,
            style = ButtonTextStyle()
        )
    }
}

@Composable
fun RegisterButton(
    email: String,
    password: String,
    confirmPassword: String,
    loginModel: (LoginWithEmail) -> Unit,
    showSpinner: (Boolean) -> Unit
) {
    val composableScope = rememberCoroutineScope()
    var result: LoginWithEmail = LoginWithEmail.Success
    Button(
        onClick = {
            composableScope.launch {
                try {
                    showSpinner(true)
                    FirebaseManager.registerEmailAndPassword(email, password)
                } catch (e: FirebaseAuthException) {
                    when (e) {
                        is FirebaseAuthUserCollisionException -> {
                            result = LoginWithEmail.UserDuplicated
                        }
                        is FirebaseAuthWeakPasswordException -> {
                            result = LoginWithEmail.InvalidPassword
                        }
                        is FirebaseAuthInvalidCredentialsException -> {
                            result = LoginWithEmail.InvalidEmail
                        }
                        else -> {
                            result = LoginWithEmail.Unexpected
                        }
                    }
                } finally {
                    result.showPopUp = true
                    showSpinner(false)
                    loginModel(result)
                }
            }
        },
        enabled = TextUtils.checkEmail(email) &&
                TextUtils.checkPassword(password) &&
                TextUtils.checkPasswordAndConfirmPassword(password, confirmPassword),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonBackgroundColor()
    ) {
        Text(
            text = StringTexts.register,
            style = ButtonTextStyle()
        )
    }
}

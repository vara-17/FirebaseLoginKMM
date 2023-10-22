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


@Composable
fun LoginButton(email2: String, password2: String) {
    val composableScope = rememberCoroutineScope()
    val email = "varaandres17@gmail.com"
    val password = "123456"
    Button(
        onClick = {
            composableScope.launch {
                FirebaseManager.signInEmailAndPassword(email, password)
            }
            //}, enabled = loginEnabled, modifier = Modifier.fillMaxWidth()
        }, enabled = enableLogin(email, password), modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Sign in")
    }
}

fun enableLogin(email: String, password: String): Boolean {
    return TextUtils.checkEmail(email)
            && TextUtils.checkPassword(password)
}

@Composable
fun RememberButton(
    email2: String,
    rememberModel: (RememberPassword) -> Unit,
    showSpinner: (Boolean) -> Unit
) {
    val composableScope = rememberCoroutineScope()
    val email = "varaandres17@gmail.com"
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
                }finally {
                    result.showPopUp = true
                    showSpinner(false)
                    rememberModel(result)
                }
            }
       // }, enabled = enableRemember(email), modifier = Modifier.fillMaxWidth()
        }, enabled = true, modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Enviar")
    }
}

fun enableRemember(email: String): Boolean = TextUtils.checkEmail(email)



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
        enabled = enableRegister(email, password, confirmPassword),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Registrar")
    }
}

fun enableRegister(email: String, password: String, confirmPassword: String): Boolean {
    return TextUtils.checkEmail(email) && TextUtils.checkPassword(password) && TextUtils.checkPasswordAndConfirmPassword(
        password, confirmPassword
    )
}
package data.firebase.model

sealed class LoginWithEmail(val text: String, var showPopUp: Boolean = false){
    object Success: LoginWithEmail("Sign in successfully.")
    object InvalidEmail: LoginWithEmail("Email mailformed.")
    object InvalidPassword: LoginWithEmail("Weak password.")
    object UserDuplicated: LoginWithEmail("Email is already in use.")
    object Unexpected: LoginWithEmail("Unexpected error. Try again later.")
}

sealed class RememberPassword(val text: String, var showPopUp: Boolean = false){
    object Success: RememberPassword("Email de recuperación enviado. Revisa tu correo para recuperar la contraseña.")
    object InvalidEmail: RememberPassword("Email mailformed.")
    object Unexpected: RememberPassword("Unexpected error. Try again later.")
}
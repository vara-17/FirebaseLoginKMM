package domain.utils

object TextUtils {

    /*
    * Register View
    */
    fun checkEmail(email: String): Boolean {
        return email.contains(".") && email.contains("@")
    }

    fun checkPassword(password: String): Boolean {
        return password.length >= 6
    }

    fun checkPasswordAndConfirmPassword(password: String, comfirmPassword: String): Boolean {
        return password.equals(comfirmPassword)
    }
}
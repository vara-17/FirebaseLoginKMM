package domain.utils

class TextUtils{
    companion object{

        /*
        * Register View
        */
        fun checkEmail(email: String): Boolean{
            return email.contains(".") && email.contains("@")
        }

        fun checkPassword(password: String): Boolean{
            return password.length >= 2
        }

        fun checkPasswordAndConfirmPassword(password: String, comfirmPassword: String): Boolean{
            return password.equals(comfirmPassword)
        }
    }
}
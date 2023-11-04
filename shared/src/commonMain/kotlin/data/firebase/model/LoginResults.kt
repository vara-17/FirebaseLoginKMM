package data.firebase.model

import res.StringTexts

sealed class LoginWithEmail(val text: String, var showPopUp: Boolean = false) {
    object Success : LoginWithEmail(StringTexts.signUpSuccessInfo)
    object InvalidEmail : LoginWithEmail(StringTexts.emailMalformedInfo)
    object InvalidPassword : LoginWithEmail(StringTexts.signUpWeakPassword)
    object UserDuplicated : LoginWithEmail(StringTexts.signUpEmailDuplicatedInfo)
    object Unexpected : LoginWithEmail(StringTexts.generalErrorTryAgainInfo)
}

sealed class RememberPassword(val text: String, var showPopUp: Boolean = false) {
    object Success : RememberPassword(StringTexts.forgotPasswordSuccessInfo)
    object InvalidEmail : RememberPassword(StringTexts.emailMalformedInfo)
    object Unexpected : RememberPassword(StringTexts.generalErrorTryAgainInfo)
}
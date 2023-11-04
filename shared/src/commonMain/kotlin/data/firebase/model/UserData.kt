package data.firebase.model

data class UserData(
    var uid: String,
    var email: String? = null,
    var isEmailVerified: Boolean = false,
    var name: String? = null,
    var photoUrl: String? = null,
    var phone: String? = null
)
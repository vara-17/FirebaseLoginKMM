package data.firebase

import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth

class FirebaseRegister {

    companion object {
        suspend fun registerEmailAndPassword(
            auth: FirebaseAuth,
            email: String,
            password: String
        ): AuthResult = auth.createUserWithEmailAndPassword(email, password)

        suspend fun rememberPassword(
            auth: FirebaseAuth,
            email: String
        ) = auth.sendPasswordResetEmail(email)

    }
}
package data.firebase.model

import data.firebase.FirebaseRegister
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object FirebaseManager {

    private lateinit var coroutineHandler: CoroutineScope
    var auth: FirebaseAuth = Firebase.auth

    lateinit var user: UserData

    private val _isUserLogged = MutableStateFlow<Boolean>(false)
    val isUserLogged: StateFlow<Boolean> = _isUserLogged

    init {
        _isUserLogged.value = auth.currentUser != null
    }

    /*
     * Setters
     */
    fun setCoroutineHandler(coroutineHandler: CoroutineScope) {
        FirebaseManager.coroutineHandler = coroutineHandler
    }

    /*
    * Sign in/out methods
    */
    suspend fun signInEmailAndPassword(email: String, password: String) {
        val result: AuthResult = auth.signInWithEmailAndPassword(
            email,
            password
        )
        _isUserLogged.value = auth.currentUser != null
        user = UserData(auth.currentUser?.uid ?: "")
    }

    suspend fun signOut() {
        auth.signOut()
        _isUserLogged.value = auth.currentUser != null
    }

    /*
    * Register methods
    */
    suspend fun registerEmailAndPassword(email: String, password: String) {
        FirebaseRegister.registerEmailAndPassword(
            auth,
            email,
            password
        )
        _isUserLogged.value = auth.currentUser != null
    }

    /*
     * Remember password methods
     */
    suspend fun rememberPassword(email: String) {
        FirebaseRegister.rememberPassword(auth, email)
    }


}
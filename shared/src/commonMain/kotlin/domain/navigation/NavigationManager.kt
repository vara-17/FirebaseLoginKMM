package domain.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

object NavigationManager {

    private val _showLoginView = MutableStateFlow<Boolean>(true)
    val showLoginView: StateFlow<Boolean> = _showLoginView

    private val _showSignUpView = MutableStateFlow<Boolean>(false)
    val showSignUpView: StateFlow<Boolean> = _showSignUpView

    private val _showRememberPasswordView = MutableStateFlow<Boolean>(false)
    val showRememberPasswordView: StateFlow<Boolean> = _showRememberPasswordView

    private val _showPostLoginView = MutableStateFlow<Boolean>(false)
    val showPostLoginView: StateFlow<Boolean> = _showPostLoginView

    fun setShowLoginView(show: Boolean) {
        _showLoginView.value = show
    }

    fun setShowSignUpView(show: Boolean) {
        _showSignUpView.value = show
        _showRememberPasswordView.value = false
    }

    fun setShowRememberPassword(show: Boolean) {
        _showRememberPasswordView.value = show
        _showSignUpView.value = false
    }

    fun setShowPostLoginView(show: Boolean) {
        _showPostLoginView.value = show
    }

}
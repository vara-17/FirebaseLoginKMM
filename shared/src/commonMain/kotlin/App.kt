import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import data.firebase.model.FirebaseManager
import domain.navigation.NavigationManager
import org.jetbrains.compose.resources.ExperimentalResourceApi
import ui.components.textfield.*
import ui.login.LoginView
import ui.login.RememberPasswordView
import ui.login.SignUpEmailAndPasswordView
import ui.login.UserLoggedView


@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    InitializeApplication.InitApp()
    val isUserLogged: State<Boolean> = FirebaseManager.isUserLogged.collectAsState()
    val showRegisterView: State<Boolean> = NavigationManager.showSignUpView.collectAsState()
    val showRememberPasswordView: State<Boolean> = NavigationManager.showRememberPasswordView.collectAsState()

    MaterialTheme {
        Box() {
            if(showRegisterView.value) {
                SignUpEmailAndPasswordView()
            }else if(showRememberPasswordView.value){
                RememberPasswordView()
            }else{
                if (!isUserLogged.value) {
                    LoginView()
                } else {
                    UserLoggedView()
                }
            }
        }
    }
}
expect fun getPlatformName(): String
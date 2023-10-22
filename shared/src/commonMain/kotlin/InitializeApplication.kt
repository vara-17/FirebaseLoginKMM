import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import data.firebase.model.FirebaseManager

class InitializeApplication {

    companion object{
        @Composable
        fun InitApp(){
            InitFirebase()
        }

        @Composable
        private fun InitFirebase(){
            FirebaseManager.setCoroutineHandler(rememberCoroutineScope())
        }
    }

}
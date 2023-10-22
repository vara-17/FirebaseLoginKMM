import android.util.Patterns
import androidx.compose.runtime.Composable

actual fun getPlatformName(): String = "Android"

@Composable fun MainView() = App()


fun asad(){
    Patterns.EMAIL_ADDRESS
}
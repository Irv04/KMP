import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.example.kmp.di.initKoin
import com.example.kmp.ui.App

fun main(){
    initKoin()

    application {

        val windowState = rememberWindowState()

        Window(
            onCloseRequest = ::exitApplication,
            state = windowState,
            title = "News App"
        ){
            Surface(modifier = Modifier.fillMaxSize()) {
                App()
            }
        }
    }
}
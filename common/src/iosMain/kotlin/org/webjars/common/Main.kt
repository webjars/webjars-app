package kotlinbars.compose.org.webjars.common

import androidx.compose.ui.window.ComposeUIViewController
import org.webjars.common.WebJars
import org.webjars.common.WebJarsRpc
import platform.UIKit.UIViewController

fun MainViewController(barsUrl: String) : UIViewController = ComposeUIViewController {
    WebJars(WebJarsRpc(barsUrl))
}

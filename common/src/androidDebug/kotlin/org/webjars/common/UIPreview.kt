package org.webjars.common

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun WebJarsListPreview() {
    val webJars = listOf(
        WebJar("classic", "org.webjars", "jquery", "JQuery", "https://github.com/jquery/jquery.git", listOf(
            WebJarVersion("3.5.1", 15)
        )),
        WebJar("classic", "org.webjars", "bootstrap", "Bootstrap", "http://github.com/webjars/bootstrap.git", listOf(
            WebJarVersion("5.3.1", 296),
            WebJarVersion("5.3.0", 296),
        )),
    )
    WebJarsList(webJars)
}
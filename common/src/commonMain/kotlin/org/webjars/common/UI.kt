package org.webjars.common

import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun WebJars(barsRpc: WebJarsRpc) {
    val popularWebJars = remember { mutableStateListOf<WebJar>() }

    //val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        popularWebJars.addAll(barsRpc.popular())
    }

    Column(Modifier.fillMaxWidth().fillMaxHeight().padding(10.dp), Arrangement.Top) {
        Text("Popular WebJars")
        WebJarsList(popularWebJars)
    }
}

@Composable
fun WebJarsList(webJars: List<WebJar>) {
    LazyColumn {
        items(webJars, { it.id }) { webJar ->
            if (webJar.versions.isNotEmpty()) {
                Row {
                    Text(webJar.name, modifier = Modifier.padding(5.dp))
                    Text(webJar.versions.first().number, modifier = Modifier.padding(5.dp))
                    val versionText = if (webJar.versions.size == 1) "version" else "versions"
                        Text(
                            "(" + webJar.versions.size + " " + versionText + ")",
                            modifier = Modifier.padding(5.dp)
                        )
                    Button(onClick = { println("clicked") }) {
                        Text("Details")
                    }
                }
            }
        }
    }
}

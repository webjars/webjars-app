package org.webjars.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.webjars.common.WebJars
import org.webjars.common.WebJarsRpc

class MainActivity : ComponentActivity() {
    private val webJarsRpc by lazy {
        val url = resources.getString(R.string.webjars_url)
        WebJarsRpc(url)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WebJars(webJarsRpc)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        webJarsRpc.close()
    }
}

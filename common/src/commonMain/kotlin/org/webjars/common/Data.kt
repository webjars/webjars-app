package org.webjars.common

import kotlinx.serialization.Serializable

@Serializable
data class WebJar(val type: String, val groupId: String, val artifactId: String, val name: String, val sourceUrl: String, val versions: List<WebJarVersion>) {
    val id = "$type:$groupId:$artifactId"
}

@Serializable
data class WebJarVersion(val number: String, val numFiles: Int)

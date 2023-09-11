package org.webjars.common

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.utils.io.core.Closeable

class WebJarsRpc(private val webJarsUrl: String) : Closeable {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    enum class GroupId(val value: String) {
        NPM("org.webjars.npm"),
        BowerGitHub("org.webjars.bowergithub.*"),
        Bower("org.webjars.bower"),
        Classic("org.webjars"),
    }

    suspend fun popular(): List<WebJar> = run {
        client.get("$webJarsUrl/popular").body()
    }

    suspend fun search(query: String, groupIds: List<GroupId> = GroupId.entries): List<WebJar> = run {
        client.get("$webJarsUrl/search") {
            url {
                parameters.append("query", query)
                groupIds.forEach {
                    parameters.append("groupId", it.value)
                }
            }
        }.body()
    }

    override fun close() {
        client.close()
    }

}

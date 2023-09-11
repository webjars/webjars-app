package org.webjars.common

import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertTrue
import org.junit.Test

class RpcTest {
    @Test
    fun popular_should_work() = runBlocking {
        WebJarsRpc("https://www.webjars.org").use { webJarsRpc ->
            val popular = webJarsRpc.popular()
            assertTrue(popular.size > 1)
        }
    }

    @Test
    fun search_should_work_with_all_groups() = runBlocking {
        WebJarsRpc("https://www.webjars.org").use { webJarsRpc ->
            val results = webJarsRpc.search("whatwg-fetch")
            assertTrue(results.size >= 3)
        }
    }

    @Test
    fun search_should_work_with_one_groupid() = runBlocking {
        WebJarsRpc("https://www.webjars.org").use { webJarsRpc ->
            val results = webJarsRpc.search("whatwg-fetch", listOf(WebJarsRpc.GroupId.Bower))
            assertTrue(results.size == 1)
        }
    }
}
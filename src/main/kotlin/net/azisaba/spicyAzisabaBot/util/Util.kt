package net.azisaba.spicyAzisabaBot.util

import java.net.URL

object Util {
    private val cache = mutableMapOf<String, Pair<Long, String>>()

    fun executeCachedTextRequest(url: String, duration: Long): String {
        cache[url]?.let { (until, text) ->
            if (until < System.currentTimeMillis()) {
                cache.remove(url)
            } else {
                return text
            }
        }
        val text = URL(url).readText()
        val until = System.currentTimeMillis() + duration
        cache[url] = Pair(until, text)
        return text
    }
}

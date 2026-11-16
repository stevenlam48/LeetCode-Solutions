package encodeanddecodetinyurl
// Time:  O(1)
// Space: O(n)

import java.util.Random

class Solution {
    private val randomLength = 6
    private val tinyUrl = "http://tinyurl.com/"
    private val alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    private val gen = Random()
    private val lookup = mutableMapOf<String, String>()

    fun encode(longUrl: String): String {
        var key = getRand()
        while (lookup.containsKey(key)) {
            key = getRand()
        }
        lookup[key] = longUrl
        return tinyUrl + key
    }

    fun decode(shortUrl: String): String {
        return lookup.getOrPut(shortUrl.substring(tinyUrl.length)) { "" }
    }

    private fun getRand(): String {
        val random = StringBuilder()
        repeat(randomLength) {
            random.append(alphabet[gen.nextInt(alphabet.length)])
        }
        return random.toString()
    }
}

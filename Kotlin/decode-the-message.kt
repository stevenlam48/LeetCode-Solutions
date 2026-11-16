package decodethemessage

// Time:  O(n + m)
// Space: O(1)

// string, hash table
class Solution {
    fun decodeMessage(key: String, message: String): String {
        val lookup = IntArray(26) { -1 }
        var i = 0
        for (ch in key) {
            val x = ch - 'a'
            if (x < 0 || lookup[x] != -1) {
                continue
            }
            lookup[x] = i++
        }
        val result = CharArray(message.length)
        for (j in message.indices) {
            val x = message[j]
            result[j] = if (x != ' ') 'a' + lookup[x - 'a'] else ' '
        }
        return String(result)
    }
}

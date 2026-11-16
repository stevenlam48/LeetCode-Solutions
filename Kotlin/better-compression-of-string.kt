package bettercompressionofstring

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun betterCompression(compressed: String): String {
        val cnt = IntArray(26)
        var x = -1
        var curr = 0
        for (i in compressed.indices) {
            if (!compressed[i].isDigit()) {
                x = compressed[i] - 'a'
                continue
            }
            curr = curr * 10 + (compressed[i] - '0')
            if (i + 1 == compressed.length || !compressed[i + 1].isDigit()) {
                cnt[x] += curr
                curr = 0
            }
        }
        val result = StringBuilder()
        for (i in cnt.indices) {
            if (cnt[i] == 0) {
                continue
            }
            result.append(('a' + i))
            result.append(cnt[i].toString())
        }
        return result.toString()
    }
}

package deletecharacterstomakefancystring

// Time:  O(n)
// Space: O(1)
class Solution {
    fun makeFancyString(s: String): String {
        val chars = s.toCharArray()
        var cnt = 0
        var j = 0
        for (i in chars.indices) {
            cnt = if (i >= 1 && chars[i] == chars[i - 1]) cnt + 1 else 1
            if (cnt < 3) chars[j++] = chars[i]
        }
        return chars.concatToString(0, j)
    }
}

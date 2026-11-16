package cleardigits

// Time:  O(n)
// Space: O(1)

class Solution {
    fun clearDigits(s: String): String {
        val result = CharArray(s.length)
        var j = 0
        for (i in s.indices) {
            if (s[i] in '0'..'9') {
                --j
                continue
            }
            result[j++] = s[i]
        }
        return String(result, 0, j)
    }
}

package countvalidprefixes

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countValidPrefixes(s: String): Int {
        var result = 0
        var prefix = 0
        for (c in s) {
            prefix += if (c == '1') 1 else -1
            if (kotlin.math.abs(prefix) <= 1) {
                ++result
            }
        }
        return result
    }
}

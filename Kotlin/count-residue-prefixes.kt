package countresidueprefixes

// Time:  O(n + 26)
// Space: O(26)

class Solution {
    fun residuePrefixes(s: String): Int {
        var result = 0
        val lookup = BooleanArray(26)
        var distinct = 0
        for (i in s.indices) {
            if (!lookup[s[i] - 'a']) {
                if (++distinct >= 3) {
                    break
                }
            }
            lookup[s[i] - 'a'] = true
            if (distinct == (i + 1) % 3) {
                ++result
            }
        }
        return result
    }
}

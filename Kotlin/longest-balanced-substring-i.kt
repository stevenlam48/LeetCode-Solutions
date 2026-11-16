package longestbalancedsubstringi

// Time:  O(n * (26 + n))
// Space: O(26)

// freq table
class Solution {
    fun longestBalanced(s: String): Int {
        var result = 0
        for (i in s.indices) {
            val cnt = IntArray(26)
            var mx = 0
            var unique = 0
            for (j in i until s.length) {
                if (++cnt[s[j] - 'a'] == 1) {
                    ++unique
                }
                mx = maxOf(mx, cnt[s[j] - 'a'])
                if ((j - i + 1) % unique == 0 && (j - i + 1) / unique == mx) {
                    result = maxOf(result, j - i + 1)
                }
            }
        }
        return result
    }
}

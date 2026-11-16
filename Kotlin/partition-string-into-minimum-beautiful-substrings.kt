package partitionstringintominimumbeautifulsubstrings

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minimumBeautifulSubstrings(s: String): Int {
        val inf = Int.MAX_VALUE
        var maxPow5 = 1
        while (maxPow5 * 5 <= (1 shl s.length) - 1) {
            maxPow5 *= 5
        }
        val dp = IntArray(s.length + 1) { inf }
        dp[0] = 0
        for (i in s.indices) {
            if (s[i] == '0') {
                continue
            }
            var curr = 0
            for (j in i until s.length) {
                curr = curr * 2 + (s[j] - '0')
                if (maxPow5 % curr == 0 && dp[i] != inf) {
                    dp[j + 1] = minOf(dp[j + 1], dp[i] + 1)
                }
            }
        }
        return if (dp.last() != inf) dp.last() else -1
    }
}

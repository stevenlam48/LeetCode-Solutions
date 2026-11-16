package minimumsubstringpartitionofequalcharacterfrequency

// Time:  O(n * (n + 26))
// Space: O(n + 26)

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun minimumSubstringsInPartition(s: String): Int {
        val dp = IntArray(s.length + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in s.indices) {
            val cnt = IntArray(26)
            var d = 0
            var mx = 0
            for (j in i downTo 0) {
                val k = s[j] - 'a'
                if (++cnt[k] == 1) {
                    ++d
                }
                mx = max(mx, cnt[k])
                if (d * mx == i - j + 1 && dp[j] != Int.MAX_VALUE) {
                    dp[i + 1] = min(dp[i + 1], dp[j] + 1)
                }
            }
        }
        return dp[s.length]
    }
}

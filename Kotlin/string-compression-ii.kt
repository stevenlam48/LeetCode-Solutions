package stringcompressionii

// Time:  O(n^2 * k)
// Space: O(n * k)

class Solution {
    fun getLengthOfOptimalCompression(s: String, k: Int): Int {
        val dp = Array(s.length + 1) { IntArray(k + 1) { s.length } }
        dp[0][0] = 0
        for (i in 1..s.length) {
            for (j in 0..k) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    dp[i][j] = minOf(dp[i][j], dp[i - 1][j - 1])
                }
                var keep = 0
                var delete = 0
                for (m in i..s.length) {
                    if (s[i - 1] == s[m - 1]) {
                        ++keep
                    } else {
                        ++delete
                    }
                    if (j + delete <= k) {
                        dp[m][j + delete] = minOf(
                            dp[m][j + delete],
                            dp[i - 1][j] + length(keep)
                        )
                    }
                }
            }
        }
        return dp[s.length][k]
    }

    private fun length(count: Int): Int {
        var remaining = count
        var result = if (remaining >= 2) 2 else 1
        while (remaining >= 10) {
            remaining /= 10
            ++result
        }
        return result
    }
}

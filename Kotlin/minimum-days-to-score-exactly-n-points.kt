package minimumdaystoscoreexactlynpoints

// Time:  O(n * sqrt(n))
// Space: O(n)

class Solution {
    fun minDays(n: Int): Int {
        fun count(n: Int): Int {
            return (n + 1) * n / 2
        }

        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = -1
        var d = 1
        while (count(d) <= n) {
            val c = count(d)
            val limit = minOf(c, dp.size - 1 - c)
            for (i in 0..limit) {
                dp[i + c] = minOf(dp[i + c], dp[i] + 1 + d)
            }
            ++d
        }
        return dp[dp.size - 1]
    }
}

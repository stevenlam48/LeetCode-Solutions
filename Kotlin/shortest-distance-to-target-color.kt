package shortestdistancetotargetcolor

// Time:  O(n)
// Space: O(n)

import kotlin.math.abs

class Solution {
    fun shortestDistanceColor(colors: IntArray, queries: Array<IntArray>): IntArray {
        val dp = Array(3) { IntArray(colors.size) { -1 } }
        dp[colors[0] - 1][0] = 0
        for (i in 1 until colors.size) {
            for (color in 0 until 3) {
                dp[color][i] = dp[color][i - 1]
            }
            dp[colors[i] - 1][i] = i
        }
        dp[colors[colors.lastIndex] - 1][colors.lastIndex] = colors.lastIndex
        for (i in colors.size - 2 downTo 0) {
            for (color in 0 until 3) {
                if (dp[color][i + 1] != -1) {
                    continue
                }
                if (dp[color][i] == -1 || abs(dp[color][i + 1] - i) < abs(dp[color][i] - i)) {
                    dp[color][i] = dp[color][i + 1]
                }
            }
            dp[colors[i] - 1][i] = i
        }
        val result = IntArray(queries.size)
        for (i in queries.indices) {
            val query = queries[i]
            result[i] = if (dp[query[1] - 1][query[0]] != -1) {
                abs(dp[query[1] - 1][query[0]] - query[0])
            } else {
                -1
            }
        }
        return result
    }
}

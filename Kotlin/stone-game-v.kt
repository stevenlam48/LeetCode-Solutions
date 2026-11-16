package stonegamev

// Time:  O(n^2)
// Space: O(n^2)

class Solution {
    fun stoneGameV(stoneValue: IntArray): Int {
        val n = stoneValue.size
        val prefix = IntArray(n + 1)
        for (i in 0 until n) {
            prefix[i + 1] = prefix[i] + stoneValue[i]
        }

        val mid = IntArray(n) { it }

        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = stoneValue[i]
        }

        var maxScore = 0
        for (l in 2..n) {
            for (i in 0..n - l) {
                val j = i + l - 1
                while (prefix[mid[i]] - prefix[i] < prefix[j + 1] - prefix[mid[i]]) {
                    ++mid[i]
                }
                val p = mid[i]
                maxScore = 0
                if (prefix[p] - prefix[i] == prefix[j + 1] - prefix[p]) {
                    maxScore = maxOf(dp[i][p - 1], dp[j][p])
                } else {
                    if (i <= p - 2) {
                        maxScore = maxOf(maxScore, dp[i][p - 2])
                    }
                    if (p <= j) {
                        maxScore = maxOf(maxScore, dp[j][p])
                    }
                }
                dp[i][j] = maxOf(dp[i][j - 1], (prefix[j + 1] - prefix[i]) + maxScore)
                dp[j][i] = maxOf(dp[j][i + 1], (prefix[j + 1] - prefix[i]) + maxScore)
            }
        }
        return maxScore
    }
}

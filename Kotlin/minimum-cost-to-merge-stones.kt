package minimumcosttomergestones
// Time:  O(n^3 / k)
// Space: O(n^2)

class Solution {
    fun mergeStones(stones: IntArray, K: Int): Int {
        if ((stones.size - 1) % (K - 1) != 0) {
            return -1
        }
        val prefix = IntArray(stones.size + 1)
        for (i in stones.indices) {
            prefix[i + 1] = prefix[i] + stones[i]
        }
        val dp = Array(stones.size) { IntArray(stones.size) }
        for (l in K - 1 until stones.size) {
            for (i in 0 until stones.size - l) {
                dp[i][i + l] = Int.MAX_VALUE
                var j = i
                while (j + 1 <= i + l) {
                    dp[i][i + l] = minOf(dp[i][i + l], dp[i][j] + dp[j + 1][i + l])
                    j += K - 1
                }
                if (l % (K - 1) == 0) {
                    dp[i][i + l] += prefix[i + l + 1] - prefix[i]
                }
            }
        }
        return dp[0][stones.lastIndex]
    }
}

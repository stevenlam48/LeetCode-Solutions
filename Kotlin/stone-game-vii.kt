package stonegamevii

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun stoneGameVII(stones: IntArray): Int {
        val prefix = IntArray(stones.size + 1)
        for (i in stones.indices) {
            prefix[i + 1] = prefix[i] + stones[i]
        }
        fun score(i: Int, j: Int): Int {
            return prefix[j + 1] - prefix[i]
        }
        val dp = Array(2) { IntArray(stones.size) }
        for (i in stones.size - 1 downTo 0) {
            for (j in i + 1 until stones.size) {
                dp[i % 2][j] = maxOf(
                    score(i + 1, j) - dp[(i + 1) % 2][j],
                    score(i, j - 1) - dp[i % 2][j - 1]
                )
            }
        }
        return dp[0][stones.size - 1]
    }
}

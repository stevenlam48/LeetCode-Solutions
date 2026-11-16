package stonegame

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun stoneGame(piles: IntArray): Boolean {
        if (piles.size % 2 == 0 || piles.size == 1) {
            return true
        }

        val dp = IntArray(piles.size)
        for (i in piles.size - 1 downTo 0) {
            dp[i] = piles[i]
            for (j in i + 1 until piles.size) {
                dp[j] = maxOf(piles[i] - dp[j], piles[j] - dp[j - 1])
            }
        }

        return dp[piles.size - 1] >= 0
    }
}

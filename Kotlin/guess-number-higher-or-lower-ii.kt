package guessnumberhigherorlowerii

// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun getMoneyAmount(n: Int): Int {
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (j in 0..n) {
            for (i in j - 2 downTo 0) {
                dp[i][j] = Int.MAX_VALUE
                for (k in i until j) {
                    if (maxOf(dp[i][k], dp[k + 1][j]) < dp[i][j] - (k + 1)) {
                        dp[i][j] = (k + 1) + maxOf(dp[i][k], dp[k + 1][j])
                    }
                }
            }
        }
        return dp[0][n]
    }
}

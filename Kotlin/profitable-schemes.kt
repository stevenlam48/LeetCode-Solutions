package profitableschemes

// Time:  O(n * p * g)
// Space: O(p * g)

class Solution {
    fun profitableSchemes(G: Int, P: Int, group: IntArray, profit: IntArray): Int {
        val dp = Array(P + 1) { IntArray(G + 1) }
        dp[0][0] = 1
        var result = 0
        for (k in group.indices) {
            val g = group[k]
            val p = profit[k]
            for (i in P downTo 0) {
                for (j in G - g downTo 0) {
                    val newProfit = minOf(i + p, P)
                    dp[newProfit][j + g] = (dp[newProfit][j + g] + dp[i][j]) % M
                }
            }
        }
        for (p in dp[P]) {
            result = (result + p) % M
        }
        return result
    }

    companion object {
        private const val M = 1000000007
    }
}

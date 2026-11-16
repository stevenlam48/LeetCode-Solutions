package minimumcostpathwithalternatingdirectionsii

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun minCost(m: Int, n: Int, waitCost: Array<IntArray>): Long {
        waitCost[0][0] = 0
        waitCost[m - 1][n - 1] = 0
        val dp = LongArray(n)
        for (i in 0 until m) {
            for (j in 0 until n) {
                var prev = if (i == 0 && j == 0) 0L else Long.MAX_VALUE
                if (i - 1 >= 0) {
                    prev = minOf(prev, dp[j])
                }
                if (j - 1 >= 0) {
                    prev = minOf(prev, dp[j - 1])
                }
                dp[j] = prev + waitCost[i][j] + (i + 1).toLong() * (j + 1)
            }
        }
        return dp[n - 1]
    }
}

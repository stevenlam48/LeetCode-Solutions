package painthouseiii
// Time:  O(m * t * n^2)
// Space: O(t * n)

class Solution {
    fun minCost(houses: IntArray, cost: Array<IntArray>, m: Int, n: Int, target: Int): Int {
        val dp = Array(2) { Array(target) { IntArray(n) { Int.MAX_VALUE } } }
        for (i in 0 until m) {
            dp[i % 2] = Array(target) { IntArray(n) { Int.MAX_VALUE } }
            for (j in 0 until minOf(target, i + 1)) {
                for (k in 0 until n) {
                    if (houses[i] != 0 && houses[i] - 1 != k) {
                        continue
                    }
                    var same = 0
                    if (i - 1 >= 0) {
                        same = dp[(i - 1) % 2][j][k]
                    }
                    var diff = 0
                    if (i - 1 >= 0) {
                        diff = Int.MAX_VALUE
                        if (j - 1 >= 0) {
                            for (nk in 0 until n) {
                                if (nk == k) {
                                    continue
                                }
                                diff = minOf(diff, dp[(i - 1) % 2][j - 1][nk])
                            }
                        }
                    }
                    dp[i % 2][j][k] = minOf(same, diff)
                    if (dp[i % 2][j][k] != Int.MAX_VALUE && houses[i] == 0) {
                        dp[i % 2][j][k] += cost[i][k]
                    }
                }
            }
        }
        val result = dp[(m - 1) % 2].last().min()
        return if (result != Int.MAX_VALUE) result else -1
    }
}

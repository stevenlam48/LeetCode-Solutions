package minimumnumberofoperationstosatisfyconditions

// Time:  O(n * (m + 10))
// Space: O(10)

class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val inf = Int.MAX_VALUE
        val maxValue = 9

        fun top(dp: IntArray, exclude: Int): Int {
            var j = -1
            for (i in 0..maxValue) {
                if (i == exclude) {
                    continue
                }
                if (j == -1 || dp[i] < dp[j]) {
                    j = i
                }
            }
            return j
        }

        var dp = IntArray(maxValue + 1)
        for (j in grid[0].indices) {
            val cnt = IntArray(maxValue + 1)
            for (i in grid.indices) {
                ++cnt[grid[i][j]]
            }
            val newDp = IntArray(maxValue + 1) { inf }
            for (i in 0..maxValue) {
                val k1 = top(dp, -1)
                val k2 = top(dp, k1)
                newDp[i] = minOf(
                    newDp[i],
                    (if (i != k1) dp[k1] else dp[k2]) + (grid.size - cnt[i])
                )
            }
            dp = newDp
        }
        return dp.min()
    }
}

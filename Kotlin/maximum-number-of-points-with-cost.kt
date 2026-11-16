package maximumnumberofpointswithcost

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun maxPoints(points: Array<IntArray>): Long {
        var dp = LongArray(points[0].size) { points[0][it].toLong() }
        for (i in 1 until points.size) {
            val n = points[i].size
            val prefix = LongArray(n)
            prefix[0] = dp[0]
            for (j in 1 until n) {
                prefix[j] = maxOf(prefix[j - 1], dp[j] + j)
            }
            val suffix = LongArray(n)
            suffix[n - 1] = dp[n - 1] - (n - 1)
            for (j in n - 2 downTo 0) {
                suffix[j] = maxOf(suffix[j + 1], dp[j] - j)
            }
            val newDp = LongArray(n)
            for (j in 0 until n) {
                newDp[j] = maxOf(prefix[j] - j, suffix[j] + j) + points[i][j]
            }
            dp = newDp
        }
        return dp.max()
    }
}

package maximumcoincollection

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maxCoins(lane1: IntArray, lane2: IntArray): Long {
        val NEG_INF = Long.MIN_VALUE
        var result = NEG_INF
        var dp1 = NEG_INF
        var dp12 = NEG_INF
        var dp121 = NEG_INF
        for (i in lane1.indices) {
            dp1 = maxOf(dp1, 0L) + lane1[i]
            dp12 = maxOf(maxOf(dp12, 0L) + lane2[i], dp1)
            dp121 = maxOf(maxOf(dp121, 0L) + lane1[i], dp12)
            result = maxOf(result, dp1, dp121)
        }
        return result
    }
}

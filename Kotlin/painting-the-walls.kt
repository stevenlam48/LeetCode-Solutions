package paintingthewalls
// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun paintWalls(cost: IntArray, time: IntArray): Int {
        val dp = IntArray(cost.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in cost.indices) {
            for (j in cost.size downTo 1) {
                val previous = maxOf(j - (time[i] + 1), 0)
                if (dp[previous] != Int.MAX_VALUE) {
                    dp[j] = minOf(dp[j], dp[previous] + cost[i])
                }
            }
        }
        return dp.last()
    }
}

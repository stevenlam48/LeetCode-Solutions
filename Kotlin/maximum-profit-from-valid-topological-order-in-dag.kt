package maximumprofitfromvalidtopologicalorderindag

// Time:  O(n * 2^n)
// Space: O(2^n)

// dp, bitmasks
class Solution {
    fun maxProfit(n: Int, edges: Array<IntArray>, score: IntArray): Int {
        val adj = IntArray(n)
        for (e in edges) {
            adj[e[1]] = adj[e[1]] or (1 shl e[0])
        }
        val dp = IntArray(1 shl n) { -1 }
        dp[0] = 0
        for (mask in dp.indices) {
            if (dp[mask] == -1) {
                continue
            }
            val l = Integer.bitCount(mask) + 1
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0) {
                    continue
                }
                if (mask and adj[i] == adj[i]) {
                    dp[mask or (1 shl i)] = maxOf(dp[mask or (1 shl i)], dp[mask] + l * score[i])
                }
            }
        }
        return dp.last()
    }
}

package findmaximumvalueinaconstrainedsequence

// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaxVal(n: Int, restrictions: Array<IntArray>, diff: IntArray): Int {
        val INF = Int.MAX_VALUE

        val dp = IntArray(n) { INF }
        dp[0] = 0
        for (r in restrictions) {
            dp[r[0]] = r[1]
        }
        for (i in 0 until n - 1) {
            dp[i + 1] = minOf(dp[i + 1], dp[i] + diff[i])
        }
        for (i in n - 2 downTo 0) {
            dp[i] = minOf(dp[i], dp[i + 1] + diff[i])
        }
        return dp.max()
    }
}

package maximumpointstouristcanearn
// Time:  O(k * n^2)
// Space: O(n)

class Solution {
    fun maxScore(n: Int, k: Int, stayScore: Array<IntArray>, travelScore: Array<IntArray>): Int {
        var dp = IntArray(n)
        for (i in 0 until k) {
            val newDp = IntArray(n)
            for (u in 0 until n) {
                newDp[u] = dp[u] + stayScore[i][u]
            }
            for (u in 0 until n) {
                for (v in 0 until n) {
                    newDp[u] = maxOf(newDp[u], dp[v] + travelScore[v][u])
                }
            }
            dp = newDp
        }
        return dp.maxOrNull()!!
    }
}

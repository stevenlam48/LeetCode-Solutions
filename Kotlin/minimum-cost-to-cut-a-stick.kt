package minimumcosttocutastick
// Time:  O(n^3)
// Space: O(n^2)

class Solution {
    fun minCost(n: Int, cuts: IntArray): Int {
        val sortedCuts = (cuts.toList() + 0 + n).sorted().toIntArray()
        val dp = Array(sortedCuts.size) { IntArray(sortedCuts.size) }
        for (l in 2 until sortedCuts.size) {
            for (i in 0 until sortedCuts.size - l) {
                dp[i][i + l] = Int.MAX_VALUE
                for (j in i + 1 until i + l) {
                    dp[i][i + l] = minOf(dp[i][i + l], dp[i][j] + dp[j][i + l] + sortedCuts[i + l] - sortedCuts[i])
                }
            }
        }
        return dp[0][sortedCuts.lastIndex]
    }
}

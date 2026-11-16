package numberofdicerollswithtargetsum

// Time:  O(d * f * t)
// Space: O(t)

class Solution {
    fun numRollsToTarget(d: Int, f: Int, target: Int): Int {
        val mod = 1_000_000_007
        val dp = Array(2) { IntArray(target + 1) }
        dp[0][0] = 1
        for (i in 1..d) {
            dp[i % 2] = IntArray(target + 1)
            for (k in 1..f) {
                for (j in k..target) {
                    dp[i % 2][j] = (dp[i % 2][j] + dp[(i - 1) % 2][j - k]) % mod
                }
            }
        }
        return dp[d % 2][target] % mod
    }
}

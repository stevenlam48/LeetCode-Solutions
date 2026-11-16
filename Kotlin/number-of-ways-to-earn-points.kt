package numberofwaystoearnpoints

// Time:  O(n * t * c)
// Space: O(t)

class Solution {
    fun waysToReachTarget(target: Int, types: Array<IntArray>): Int {
        val MOD = 1_000_000_007

        val dp = IntArray(target + 1)
        dp[0] = 1
        for (t in types) {
            for (i in target downTo 1) {
                val maxJ = minOf(i / t[1], t[0])
                for (j in 1..maxJ) {
                    dp[i] = ((dp[i].toLong() + dp[i - j * t[1]]) % MOD).toInt()
                }
            }
        }
        return dp[target]
    }
}

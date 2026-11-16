package waystoexpressanintegerassumofpowers

// Time:  O(nlogn)
// Space: O(n)

// knapsack dp
class Solution {
    fun numberOfWays(n: Int, x: Int): Int {
        val MOD = 1_000_000_007

        val dp = IntArray(n + 1)
        dp[0] = 1
        for (i in 1..n) {
            var iPowX = 1L
            var overflow = false
            for (k in 0 until x) {
                iPowX *= i
                if (iPowX > n) {
                    overflow = true
                    break
                }
            }
            if (overflow) {
                break
            }
            val weight = iPowX.toInt()
            for (j in n downTo weight) {
                dp[j] = ((dp[j].toLong() + dp[j - weight]) % MOD).toInt()
            }
        }
        return dp[n]
    }
}

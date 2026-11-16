package findthesumofthepowerofallsubsequences

// Time:  O(n * k)
// Space: O(k)

// dp, combinatorics
class Solution {
    fun sumOfPower(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007

        val dp = LongArray(k + 1)
        dp[0] = 1
        for (x in nums) {
            for (i in k downTo 0) {
                val add = if (i - x >= 0) dp[i - x] else 0L
                dp[i] = (dp[i] + (dp[i] + add) % MOD) % MOD
            }
        }
        return dp[k].toInt()
    }
}

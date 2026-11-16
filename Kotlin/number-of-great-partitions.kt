package numberofgreatpartitions

// Time:  O(n * k)
// Space: O(k)

// knapsack dp
class Solution {
    fun countPartitions(nums: IntArray, k: Int): Int {
        val MOD = 1_000_000_007

        var total = 0L
        for (x in nums) {
            total += x
        }
        if (total < 2L * k) {
            return 0
        }
        var result = 1L
        val dp = IntArray(k)
        dp[0] = 1
        for (x in nums) {
            for (i in k - 1 - x downTo 0) {
                dp[i + x] = (dp[i + x] + dp[i]) % MOD
            }
            result = (result * 2) % MOD
        }
        var sum = 0L
        for (v in dp) {
            sum = (sum + v) % MOD
        }
        return (((result - 2 * sum) % MOD + MOD) % MOD).toInt()
    }
}

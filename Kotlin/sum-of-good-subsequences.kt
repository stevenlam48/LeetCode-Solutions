package sumofgoodsubsequences

// Time:  O(n)
// Space: O(n)

// freq table, dp
class Solution {
    fun sumOfGoodSubsequences(nums: IntArray): Int {
        val MOD = 1_000_000_007L

        var result = 0L
        val dp = HashMap<Int, Long>()
        val cnt = HashMap<Int, Long>()
        for (x in nums) {
            val c = ((cnt[x - 1] ?: 0L) + (cnt[x + 1] ?: 0L) + 1) % MOD
            cnt[x] = ((cnt[x] ?: 0L) + c) % MOD
            dp[x] = ((dp[x] ?: 0L) + (dp[x - 1] ?: 0L) + (dp[x + 1] ?: 0L) + x.toLong() * c) % MOD
        }
        for (v in dp.values) {
            result = (result + v) % MOD
        }
        return result.toInt()
    }
}

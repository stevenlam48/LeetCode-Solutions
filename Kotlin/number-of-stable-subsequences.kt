package numberofstablesubsequences

// Time:  O(n)
// Space: O(1)

// dp
class Solution {
    fun countStableSubsequences(nums: IntArray): Int {
        val MOD = 1_000_000_007

        // dp[p][i]: count of subsequences that end with exactly (i+1) consecutive numbers of parity p
        val dp = Array(2) { LongArray(2) }
        for (x in nums) {
            val p = x % 2
            dp[p][1] = (dp[p][1] + dp[p][0]) % MOD
            dp[p][0] = (dp[p][0] + 1 + dp[1 xor p][0] + dp[1 xor p][1]) % MOD
        }
        return ((dp[0][0] + dp[0][1] + dp[1][0] + dp[1][1]) % MOD).toInt()
    }
}

package countnumberofspecialsubsequences

// Time:  O(n)
// Space: O(1)

class Solution {
    fun countSpecialSubsequences(nums: IntArray): Int {
        val mod = 1_000_000_007L
        val dp = LongArray(3)
        for (x in nums) {
            dp[x] = ((dp[x] + dp[x]) % mod + (if (x - 1 >= 0) dp[x - 1] else 1)) % mod
        }
        return dp.last().toInt()
    }
}

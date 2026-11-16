package partitionequalsubsetsum

// Time:  O(n * s), s is the sum of nums.
// Space: O(s)

class Solution {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) {
            return false
        }
        val dp = BooleanArray(sum / 2 + 1)
        dp[0] = true
        for (num in nums) {
            for (i in dp.size - 1 downTo 0) {
                if (num <= i) {
                    dp[i] = dp[i] || dp[i - num]
                }
            }
        }
        return dp.last()
    }
}

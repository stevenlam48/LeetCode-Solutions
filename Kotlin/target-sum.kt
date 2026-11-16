package targetsum
// Time:  O(n * S)
// Space: O(S)

class Solution {
    fun findTargetSumWays(nums: IntArray, S: Int): Int {
        val sum = nums.sum()
        if (sum < S || (S + sum) % 2 != 0) {
            return 0
        }
        return subsetSum(nums, (S + sum) / 2)
    }

    private fun subsetSum(nums: IntArray, S: Int): Int {
        val dp = IntArray(S + 1)
        dp[0] = 1
        for (n in nums) {
            for (i in S downTo n) {
                dp[i] += dp[i - n]
            }
        }
        return dp[S]
    }
}

package getmaximumingeneratedarray

// Time:  O(n)
// Space: O(n)

private val nums = mutableListOf(0, 1)
private val dp = mutableListOf(0, 1)

class Solution {
    fun getMaximumGenerated(n: Int): Int {
        if (n + 1 > dp.size) {
            for (i in nums.size..n) {
                if (i % 2 == 0) {
                    nums.add(nums[i / 2])
                } else {
                    nums.add(nums[i / 2] + nums[i / 2 + 1])
                }
                dp.add(maxOf(dp.last(), nums.last()))
            }
        }
        return dp[n]
    }
}

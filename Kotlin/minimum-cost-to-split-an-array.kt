package minimumcosttosplitanarray

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun minCost(nums: IntArray, k: Int): Int {
        val dp = IntArray(nums.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 0 until dp.size - 1) {
            val cnt = IntArray(nums.size)
            var d = 0
            for (j in i + 1 until dp.size) {
                if (++cnt[nums[j - 1]] == 1) {
                    ++d
                } else if (cnt[nums[j - 1]] == 2) {
                    --d
                }
                dp[j] = minOf(dp[j], dp[i] + k + ((j - i) - d))
            }
        }
        return dp[dp.size - 1]
    }
}

package countincreasingquadruplets

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun countQuadruplets(nums: IntArray): Long {
        val dp = LongArray(nums.size)
        var result = 0L
        for (l in nums.indices) {
            var cnt = 0
            for (j in 0 until l) {
                if (nums[j] < nums[l]) {
                    ++cnt
                    result += dp[j]
                } else if (nums[j] > nums[l]) {
                    dp[j] += cnt.toLong()
                }
            }
        }
        return result
    }
}

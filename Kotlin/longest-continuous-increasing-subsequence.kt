package longestcontinuousincreasingsubsequence

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findLengthOfLCIS(nums: IntArray): Int {
        var result = 0
        var count = 0
        for (i in nums.indices) {
            if (i == 0 || nums[i - 1] < nums[i]) {
                result = maxOf(result, ++count)
            } else {
                count = 1
            }
        }
        return result
    }
}

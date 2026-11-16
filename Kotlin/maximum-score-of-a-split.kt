package maximumscoreofasplit

// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumScore(nums: IntArray): Long {
        var result = Long.MIN_VALUE
        var prefix = nums.sumOf { it.toLong() }
        var suffix = Int.MAX_VALUE
        for (i in nums.size - 2 downTo 0) {
            prefix -= nums[i + 1]
            suffix = minOf(suffix, nums[i + 1])
            result = maxOf(result, prefix - suffix)
        }
        return result
    }
}

package maximumsumscoreofarray
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumSumScore(nums: IntArray): Long {
        var result = Int.MIN_VALUE.toLong()
        var prefix = 0L
        var suffix = 0L
        var left = 0
        var right = nums.size - 1
        while (left < nums.size) {
            prefix += nums[left]
            suffix += nums[right]
            result = maxOf(result, prefix, suffix)
            ++left
            --right
        }
        return result
    }
}

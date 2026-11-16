package shortestunsortedcontinuoussubarray

// Time:  O(n)
// Space: O(1)

class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        val n = nums.size
        var left = -1
        var right = -2
        var maxFromLeft = nums[0]
        var minFromRight = nums[n - 1]
        for (i in 1 until n) {
            maxFromLeft = maxOf(maxFromLeft, nums[i])
            minFromRight = minOf(minFromRight, nums[n - 1 - i])
            if (nums[i] < maxFromLeft) {
                right = i
            }
            if (nums[n - 1 - i] > minFromRight) {
                left = n - 1 - i
            }
        }
        return right - left + 1
    }
}

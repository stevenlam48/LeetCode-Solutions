package maximumcountofpositiveintegerandnegativeinteger

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun maximumCount(nums: IntArray): Int {
        return maxOf(lowerBound(nums, 0), nums.size - lowerBound(nums, 1))
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        return left
    }
}

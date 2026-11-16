package findfirstandlastpositionofelementinsortedarray

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val start = lowerBound(nums, target)
        val end = upperBound(nums, target)
        if (start != nums.size && nums[start] == target) {
            return intArrayOf(start, end - 1)
        }
        return intArrayOf(-1, -1)
    }

    private fun lowerBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] >= target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun upperBound(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }
}

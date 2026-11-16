package kthlargestelementinanarray

import java.util.Random

// Time:  O(n) on average, using Median of Medians could achieve O(n) (Intro Select)
// Space: O(1)

class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nthElement(nums, k - 1)
        return nums[k - 1]
    }

    private fun nthElement(nums: IntArray, n: Int) {
        var left = 0
        var right = nums.size - 1
        val gen = Random()
        while (left <= right) {
            val pivotIdx = left + gen.nextInt(right - left + 1)
            val (pivotLeft, pivotRight) = triPartition(left, right, nums[pivotIdx], nums)
            if (pivotLeft <= n && n <= pivotRight) {
                return
            } else if (pivotLeft > n) {
                right = pivotLeft - 1
            } else {
                left = pivotRight + 1
            }
        }
    }

    private fun triPartition(leftIn: Int, rightIn: Int, target: Int, nums: IntArray): Pair<Int, Int> {
        var left = leftIn
        var right = rightIn
        var mid = left
        while (mid <= right) {
            if (nums[mid] == target) {
                ++mid
            } else if (nums[mid] > target) {
                val tmp = nums[left]
                nums[left] = nums[mid]
                nums[mid] = tmp
                ++left
                ++mid
            } else {
                val tmp = nums[mid]
                nums[mid] = nums[right]
                nums[right] = tmp
                --right
            }
        }
        return Pair(left, right)
    }
}

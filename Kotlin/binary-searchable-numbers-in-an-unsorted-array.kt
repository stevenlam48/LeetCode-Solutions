package binarysearchablenumbersinanunsortedarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun binarySearchableNumbers(nums: IntArray): Int {
        val right = IntArray(nums.size + 1) { Int.MAX_VALUE }
        for (i in nums.size downTo 1) {
            right[i - 1] = kotlin.math.min(right[i], nums[i - 1])
        }
        val result = HashSet<Int>()
        var left = Int.MIN_VALUE
        for (i in nums.indices) {
            if (left <= nums[i] && nums[i] <= right[i + 1]) {
                result.add(nums[i])
            }
            left = kotlin.math.max(left, nums[i])
        }
        return result.size
    }
}

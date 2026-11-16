package sumofbeautyinthearray

// Time:  O(n)
// Space: O(n)
class Solution {
    fun sumOfBeauties(nums: IntArray): Int {
        val right = IntArray(nums.size) { nums.last() }
        for (i in nums.size - 2 downTo 2) {
            right[i] = minOf(right[i + 1], nums[i])
        }
        var result = 0
        var left = nums.first()
        for (i in 1..nums.size - 2) {
            if (left < nums[i] && nums[i] < right[i + 1]) {
                result += 2
            } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                ++result
            }
            left = maxOf(left, nums[i])
        }
        return result
    }
}

package minimumarraychangestomakedifferencesequal

// Time:  O(n + k)
// Space: O(k)

class Solution {
    fun minChanges(nums: IntArray, k: Int): Int {
        val diff = IntArray(k + 2)
        fun update(left: Int, right: Int, value: Int) {
            diff[left] += value
            diff[right + 1] -= value
        }
        for (i in 0 until nums.size / 2) {
            val other = nums[nums.size - 1 - i]
            val current = kotlin.math.abs(nums[i] - other)
            val maximum = maxOf(nums[i], k - nums[i], other, k - other)
            update(0, current - 1, 1)
            update(current + 1, maximum, 1)
            update(maximum + 1, k, 2)
        }
        var result = nums.size / 2
        var current = 0
        for (i in 0..k) {
            current += diff[i]
            result = minOf(result, current)
        }
        return result
    }
}

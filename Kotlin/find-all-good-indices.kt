package findallgoodindices

// Time:  O(n)
// Space: O(n)

class Solution {
    fun goodIndices(nums: IntArray, k: Int): List<Int> {
        val left = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size - 1) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1
            }
        }
        val right = IntArray(nums.size) { 1 }
        for (i in nums.size - 2 downTo 1) {
            if (nums[i] <= nums[i + 1]) {
                right[i] = right[i + 1] + 1
            }
        }
        val result = mutableListOf<Int>()
        for (i in k until nums.size - k) {
            if (minOf(left[i - 1], right[i + 1]) >= k) {
                result.add(i)
            }
        }
        return result
    }
}

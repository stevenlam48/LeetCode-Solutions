package maximumor
// Time:  O(n)
// Space: O(n)

class Solution {
    fun maximumOr(nums: IntArray, k: Int): Long {
        val right = IntArray(nums.size + 1)
        for (i in nums.size - 1 downTo 0) {
            right[i] = right[i + 1] or nums[i]
        }
        var result = 0L
        var left = 0
        for (i in nums.indices) {
            result = maxOf(result, left.toLong() or (nums[i].toLong() shl k) or right[i + 1].toLong())
            left = left or nums[i]
        }
        return result
    }
}

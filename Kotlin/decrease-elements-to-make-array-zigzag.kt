package decreaseelementstomakearrayzigzag

// Time:  O(n)
// Space: O(1)

class Solution {
    fun movesToMakeZigzag(nums: IntArray): Int {
        val result = IntArray(2)
        for (i in nums.indices) {
            val left = if (i - 1 >= 0) nums[i - 1] else Int.MAX_VALUE
            val right = if (i + 1 < nums.size) nums[i + 1] else Int.MAX_VALUE
            result[i % 2] += Math.max(nums[i] - Math.min(left, right) + 1, 0)
        }
        return Math.min(result[0], result[1])
    }
}

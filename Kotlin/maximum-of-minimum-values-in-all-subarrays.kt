package maximumofminimumvaluesinallsubarrays
// Time:  O(n)
// Space: O(n)

class Solution {
    fun findMaximums(nums: IntArray): IntArray {
        val left = findBound(nums, 1)
        val right = findBound(nums, -1)
        val result = IntArray(nums.size) { -1 }
        for (i in nums.indices) {
            val length = right[i] - left[i] - 1
            result[length - 1] = maxOf(result[length - 1], nums[i])
        }
        for (i in nums.size - 2 downTo 0) {
            result[i] = maxOf(result[i], result[i + 1])
        }
        return result
    }

    private fun findBound(nums: IntArray, d: Int): IntArray {
        val init = if (d > 0) -1 else nums.size
        val begin = if (d > 0) 0 else nums.size - 1
        val end = if (d > 0) nums.size else -1
        val result = IntArray(nums.size) { init }
        val stack = ArrayDeque<Int>()
        stack.addLast(init)
        var i = begin
        while (i != end) {
            while (stack.last() != init && nums[stack.last()] >= nums[i]) {
                stack.removeLast()
            }
            result[i] = stack.last()
            stack.addLast(i)
            i += d
        }
        return result
    }
}

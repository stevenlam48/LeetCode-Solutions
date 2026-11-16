package maximumlengthofsemidecreasingsubarrays

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxSubarrayLength(nums: IntArray): Int {
        val stack = mutableListOf<Int>()
        for (i in nums.size - 1 downTo 0) {
            if (stack.isEmpty() || nums[stack.last()] > nums[i]) {
                stack.add(i)
            }
        }
        var result = 0
        for (left in nums.indices) {
            while (stack.isNotEmpty() && nums[stack.last()] < nums[left]) {
                result = maxOf(result, stack.last() - left + 1)
                stack.removeAt(stack.lastIndex)
            }
        }
        return result
    }
}

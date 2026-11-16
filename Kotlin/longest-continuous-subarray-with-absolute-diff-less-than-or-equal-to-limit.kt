package longestcontinuoussubarraywithabsolutedifflessthanorequaltolimit

// Time:  O(n)
// Space: O(n)

class Solution {
    fun longestSubarray(nums: IntArray, limit: Int): Int {
        val maxDq = ArrayDeque<Int>()
        val minDq = ArrayDeque<Int>()
        var left = 0
        for (right in nums.indices) {
            while (maxDq.isNotEmpty() && nums[maxDq.last()] <= nums[right]) {
                maxDq.removeLast()
            }
            maxDq.addLast(right)
            while (minDq.isNotEmpty() && nums[minDq.last()] >= nums[right]) {
                minDq.removeLast()
            }
            minDq.addLast(right)
            if (nums[maxDq.first()] - nums[minDq.first()] > limit) {
                if (maxDq.first() == left) {
                    maxDq.removeFirst()
                }
                if (minDq.first() == left) {
                    minDq.removeFirst()
                }
                ++left
            }
        }
        return nums.size - left
    }
}

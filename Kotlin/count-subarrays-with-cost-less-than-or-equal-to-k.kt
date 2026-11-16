package countsubarrayswithcostlessthanorequaltok

import java.util.ArrayDeque

// Time:  O(n)
// Space: O(n)

// mono deque, two pointers
class Solution {
    fun countSubarrays(nums: IntArray, k: Long): Long {
        var result = 0L
        val maxDq = ArrayDeque<Int>()
        val minDq = ArrayDeque<Int>()
        var left = 0
        for (right in nums.indices) {
            while (maxDq.isNotEmpty() && nums[maxDq.peekLast()] <= nums[right]) {
                maxDq.pollLast()
            }
            maxDq.addLast(right)
            while (minDq.isNotEmpty() && nums[minDq.peekLast()] >= nums[right]) {
                minDq.pollLast()
            }
            minDq.addLast(right)
            while ((right - left + 1).toLong() * (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()]) > k) {
                if (maxDq.isNotEmpty() && maxDq.peekFirst() == left) {
                    maxDq.pollFirst()
                }
                if (minDq.isNotEmpty() && minDq.peekFirst() == left) {
                    minDq.pollFirst()
                }
                ++left
            }
            result += right - left + 1
        }
        return result
    }
}

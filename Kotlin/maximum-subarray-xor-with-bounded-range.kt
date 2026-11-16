package maximumsubarrayxorwithboundedrange
// Time:  O(nlogr), r = max(max(nums), 1)
// Space: O(n)

import java.util.ArrayDeque

class Solution {
    fun maxXor(nums: IntArray, k: Int): Int {
        val lookup = IntArray(nums.size) { -1 }
        val maxDq = ArrayDeque<Int>()
        val minDq = ArrayDeque<Int>()
        var left = 0
        for (right in nums.indices) {
            while (maxDq.isNotEmpty() && nums[maxDq.peekLast()] <= nums[right]) {
                maxDq.removeLast()
            }
            maxDq.addLast(right)
            while (minDq.isNotEmpty() && nums[minDq.peekLast()] >= nums[right]) {
                minDq.removeLast()
            }
            minDq.addLast(right)
            while (nums[maxDq.peekFirst()] - nums[minDq.peekFirst()] > k) {
                if (maxDq.isNotEmpty() && maxDq.peekFirst() == left) {
                    maxDq.removeFirst()
                }
                if (minDq.isNotEmpty() && minDq.peekFirst() == left) {
                    minDq.removeFirst()
                }
                ++left
            }
            lookup[right] = left
        }
        var result = 0
        val mx = maxOf(nums.maxOrNull()!!, 1)
        val bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(mx)
        for (i in bitLength - 1 downTo 0) {
            val lookup2 = HashMap<Int, Int>()
            lookup2[0] = 0
            var prefix = 0
            for (right in nums.indices) {
                prefix = prefix xor (nums[right] shr i)
                val target = ((result shr i) or 1) xor prefix
                val index = lookup2[target]
                if (index != null && index >= lookup[right]) {
                    result = result or (1 shl i)
                    break
                }
                lookup2[prefix] = right + 1
            }
        }
        return result
    }
}

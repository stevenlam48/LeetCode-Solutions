package maximumincreasingtripletvalue

// Time:  O(nlogn)
// Space: O(n)

import java.util.TreeSet

class Solution {
    fun maximumTripletValue(nums: IntArray): Int {
        val left = TreeSet<Int>()
        val right = IntArray(nums.size)
        for (i in nums.size - 2 downTo 1) {
            right[i] = maxOf(right[i + 1], nums[i + 1])
        }
        var result = 0
        for (i in 1 until nums.size - 1) {
            left.add(nums[i - 1])
            val previous = left.lower(nums[i])
            if (previous != null && right[i] > nums[i]) {
                result = maxOf(result, previous - nums[i] + right[i])
            }
        }
        return result
    }
}

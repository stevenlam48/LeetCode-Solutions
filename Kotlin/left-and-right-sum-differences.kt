package leftandrightsumdifferences
// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun leftRightDifference(nums: IntArray): IntArray {
        val total = nums.sum()
        val result = IntArray(nums.size)
        var curr = 0
        for ((i, x) in nums.withIndex()) {
            curr += x
            result[i] = abs((curr - x) - (total - curr))
        }
        return result
    }
}

package makearrayelementsequaltozero

// Time:  O(n)
// Space: O(1)

import kotlin.math.abs

class Solution {
    fun countValidSelections(nums: IntArray): Int {
        var result = 0
        var curr = 0
        val total = nums.sum()
        for (i in nums.indices) {
            if (nums[i] == 0) {
                result += maxOf(2 - abs(curr - (total - curr)), 0)
            } else {
                curr += nums[i]
            }
        }
        return result
    }
}

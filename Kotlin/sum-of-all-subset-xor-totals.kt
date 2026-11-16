package sumofallsubsetxortotals

import kotlin.math.pow

// Time:  O(n)
// Space: O(1)
class Solution {
    fun subsetXORSum(nums: IntArray): Int {
        var result = 0
        for (x in nums) {
            result = result or x
        }
        return (result * 2.0.pow(nums.size - 1)).toInt()
    }
}

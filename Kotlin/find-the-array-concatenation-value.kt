package findthearrayconcatenationvalue

import kotlin.math.log10
import kotlin.math.pow

// Time:  O(nlogr)
// Space: O(1)
class Solution {
    fun findTheArrayConcVal(nums: IntArray): Long {
        var result = 0L
        for (i in 0 until nums.size / 2) {
            val b = nums[nums.lastIndex - i]
            result += (nums[i] * 10.0.pow(log10(b.toDouble()).toInt() + 1)).toLong()
        }
        for (i in nums.size / 2 until nums.size) {
            result += nums[i]
        }
        return result
    }
}

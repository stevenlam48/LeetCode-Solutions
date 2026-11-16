package makeapositivearray

// Time:  O(n)
// Space: O(1)

import java.math.BigInteger

class Solution {
    fun makeArrayPositive(nums: IntArray): Int {
        var result = 0
        var prev1 = BigInteger.valueOf(nums[0].toLong()).add(BigInteger.valueOf(nums[1].toLong()))
        var prev2 = BigInteger.valueOf(nums[0].toLong())
        var maxPrev3 = BigInteger.ZERO
        for (i in 2 until nums.size) {
            var prefix = prev1.add(BigInteger.valueOf(nums[i].toLong()))
            if (prefix.subtract(maxPrev3) <= BigInteger.ZERO) {
                prefix = prev1.add(MAX_VAL)
                ++result
            }
            maxPrev3 = maxPrev3.max(prev2)
            prev2 = prev1
            prev1 = prefix
        }
        return result
    }

    companion object {
        private val MAX_VAL = BigInteger.valueOf(1_000_000_000_000_000_000L)
    }
}

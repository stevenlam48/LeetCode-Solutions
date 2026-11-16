package partitionarrayintotwoequalproductsubsets

import java.math.BigInteger

// Time:  O(n * 2^n)
// Space: O(1)

// bitmasks
class Solution {
    fun checkEqualPartitions(nums: IntArray, target: Long): Boolean {
        val targetValue = BigInteger.valueOf(target)
        val limit = targetValue.multiply(targetValue)
        var total = BigInteger.ONE
        for (x in nums) {
            total = total.multiply(BigInteger.valueOf(x.toLong()))
            if (total > limit) {
                return false
            }
        }
        if (total != limit) {
            return false
        }
        for (mask in 1 until (1 shl nums.size) - 1) {
            var curr = BigInteger.ONE
            for (i in nums.indices) {
                if ((mask and (1 shl i)) == 0) {
                    continue
                }
                curr = curr.multiply(BigInteger.valueOf(nums[i].toLong()))
                if (curr > targetValue) {
                    break
                }
            }
            if (curr == targetValue) {
                return true
            }
        }
        return false
    }
}

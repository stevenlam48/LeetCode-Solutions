package maximumproductoftwointegerswithnocommonbits

// Time:  O(n + rlogr), r = max(nums)
// Space: O(r)

// dp, bitmasks
class Solution {
    fun maxProduct(nums: IntArray): Long {
        val maxValue = nums.maxOrNull() ?: 0
        val l = if (maxValue != 0) 32 - Integer.numberOfLeadingZeros(maxValue) else 0
        val dp = IntArray(1 shl l)
        for (x in nums) {
            dp[x] = x
        }
        for (i in 0 until l) {
            var j = 0
            while (j < (1 shl l)) {
                for (k in j until j + (1 shl i)) {
                    if (dp[k] > dp[k + (1 shl i)]) {
                        dp[k + (1 shl i)] = dp[k]
                    }
                }
                j += 1 shl (i + 1)
            }
        }
        var result = 0L
        for (x in nums) {
            val v = x.toLong() * dp[((1 shl l) - 1) xor x]
            if (v > result) {
                result = v
            }
        }
        return result
    }
}

package concatenateddivisibility
// Time:  O(nlogr + k * n * 2^n)
// Space: O(logr + k * 2^n)

class Solution {
    fun concatenatedDivisibility(nums: IntArray, k: Int): IntArray {
        fun length(value: Int): Int {
            var x = value
            var result = 0
            while (x > 0) {
                ++result
                x /= 10
            }
            return maxOf(result, 1)
        }

        val lookup = IntArray(nums.size) { length(nums[it]) }
        val mx = lookup.max()
        val pow10 = IntArray(mx + 1)
        pow10[0] = 1 % k
        for (i in 0 until pow10.size - 1) {
            pow10[i + 1] = pow10[i] * 10 % k
        }
        val dp = Array(1 shl nums.size) { BooleanArray(k) }
        dp[dp.lastIndex][0] = true
        for (mask in dp.size - 2 downTo 0) {
            for (r in 0 until k) {
                for (i in nums.indices) {
                    if (mask and (1 shl i) != 0) {
                        continue
                    }
                    if (dp[mask or (1 shl i)][(r * pow10[lookup[i]] + nums[i]) % k]) {
                        dp[mask][r] = true
                        break
                    }
                }
            }
        }
        if (!dp[0][0]) {
            return intArrayOf()
        }
        val result = IntArray(nums.size)
        val order = nums.mapIndexed { i, value -> value to i }.sortedWith(compareBy({ it.first }, { it.second }))
        var mask = 0
        var r = 0
        for (position in nums.indices) {
            for ((_, i) in order) {
                if (mask and (1 shl i) != 0) {
                    continue
                }
                val next = (r * pow10[lookup[i]] + nums[i]) % k
                if (dp[mask or (1 shl i)][next]) {
                    result[position] = nums[i]
                    mask = mask or (1 shl i)
                    r = next
                    break
                }
            }
        }
        return result
    }
}

package sumofdecodednumbers

import kotlin.math.pow

// Time:  O(nlogr)
// Space: O(1)

// fast exponentiation
class Solution {
    fun sumDecoded(nums: LongArray): Int {
        val MOD = 1_000_000_007L
        fun powmod(a0: Long, b0: Long, mod: Long): Long {
            var a = a0 % mod
            var b = b0
            var result = 1L
            while (b != 0L) {
                if (b and 1L == 1L) {
                    result = result * a % mod
                }
                a = a * a % mod
                b = b shr 1
            }
            return result
        }

        fun length(x0: Long): Int {
            var x = x0
            var result = 0
            while (x != 0L) {
                ++result
                x /= 10
            }
            return result
        }

        var result = 0L
        for (v in nums) {
            val d = v / 10
            val w = v % 10
            val base = 10.0.pow((length(d) - w).toDouble()).toLong()
            val x = d / base
            val y = d % base
            result = (result + powmod(x, y, MOD)) % MOD
        }
        return result.toInt()
    }
}

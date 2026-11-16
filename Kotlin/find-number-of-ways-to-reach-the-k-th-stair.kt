package findnumberofwaystoreachthekthstair

// Time:  O(logk)
// Space: O(logk)

import java.math.BigInteger

class Solution {
    fun waysToReachStair(k: Int): Int {
        fun bitLength(x: Int): Int {
            return 32 - x.countLeadingZeroBits()
        }

        fun ceilLog2X(x: Int): Int {
            return bitLength(x - 1)
        }

        var l = ceilLog2X(k)
        while ((1L shl l) - k <= l + 1) {
            ++l
        }
        val fact = Array(l + 1) { BigInteger.ONE }
        for (i in 0 until fact.size - 1) {
            fact[i + 1] = fact[i] * BigInteger.valueOf((i + 1).toLong())
        }
        fun nCr(n: Int, r: Int): BigInteger {
            if (r < 0 || r > n) {
                return BigInteger.ZERO
            }
            return fact[n] / fact[r] / fact[n - r]
        }

        var result = 0
        for (i in 0 until l) {
            result += nCr(i + 1, (1 shl i) - k).toInt()
        }
        return result
    }
}

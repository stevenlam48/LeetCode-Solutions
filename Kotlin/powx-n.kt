package powxn

import kotlin.math.abs

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun myPow(x: Double, n: Int): Double {
        var base = x
        var result = 1.0
        var absN = abs(n.toLong())
        while (absN > 0) {
            if (absN and 1L == 1L) {
                result *= base
            }
            absN = absN shr 1
            base *= base
        }
        return if (n < 0) 1 / result else result
    }
}

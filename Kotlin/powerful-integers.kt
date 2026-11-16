package powerfulintegers

import kotlin.math.floor
import kotlin.math.ln

// Time:  O((logn)^2), n is the bound
// Space: O(r),        r is the size of the result

class Solution {
    fun powerfulIntegers(x: Int, y: Int, bound: Int): IntArray {
        val result = HashSet<Int>()
        val logX = if (x != 1) floor(ln(bound.toDouble()) / ln(x.toDouble())).toInt() + 1 else 1
        val logY = if (y != 1) floor(ln(bound.toDouble()) / ln(y.toDouble())).toInt() + 1 else 1
        var i = 0
        var powX = 1
        while (i < logX) {
            var j = 0
            var powY = 1
            while (j < logY) {
                val value = powX + powY
                if (value <= bound) {
                    result.add(value)
                }
                powY *= y
                ++j
            }
            powX *= x
            ++i
        }
        return result.toIntArray()
    }
}

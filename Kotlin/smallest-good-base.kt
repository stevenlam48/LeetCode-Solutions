package smallestgoodbase

import kotlin.math.ln
import kotlin.math.pow

// Time:  O((logn)^2)
// Space: O(1)

class Solution {
    fun smallestGoodBase(n: String): String {
        val num = n.toLong()
        var l = (ln(num.toDouble()) / ln(2.0)).toInt()
        while (l >= 2) {
            val b = num.toDouble().pow(1.0 / l).toLong()
            var sum = 0L
            var curr = 1L
            for (i in 0..l) {
                sum += curr
                curr *= b
            }
            if (sum == num) {
                return b.toString()
            }
            --l
        }
        return (num - 1).toString()
    }
}

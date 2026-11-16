package digitcountinrange

import kotlin.math.max
import kotlin.math.min

// Time:  O(logn)
// Space: O(1)

class Solution {
    fun digitsCount(d: Int, low: Int, high: Int): Int {
        return digitsCount(high, d) - digitsCount(low - 1, d)
    }

    private fun digitsCount(n0: Int, k: Int): Int {
        val n = n0.toLong()
        var result = 0L
        var pivot = 1L
        while (n >= pivot) {
            result += n / (10 * pivot) * pivot +
                min(pivot, max(n % (10 * pivot) - k * pivot + 1, 0L))
            if (k == 0) {
                result -= pivot
            }
            pivot *= 10
        }
        return result.toInt()
    }
}

package steppingnumbers

// Time:  O(logk + r), r is the size of result
// Space: O(k), k is the size of stepping numbers in [0, high]

class Solution {
    fun countSteppingNumbers(low: Int, high: Int): IntArray {
        val lit = lowerBound(RESULT, low)
        val rit = upperBound(RESULT, high)
        return RESULT.copyOfRange(lit, rit)
    }

    private fun lowerBound(a: IntArray, target: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] < target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    private fun upperBound(a: IntArray, target: Int): Int {
        var lo = 0
        var hi = a.size
        while (lo < hi) {
            val mid = (lo + hi) ushr 1
            if (a[mid] <= target) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }

    companion object {
        private const val MAX_HIGH = 2_000_000_000

        private val RESULT: IntArray = run {
            val result = IntArray(3504)
            for (i in 0..9) {
                result[i] = i
            }
            var i = 1
            var l = 10
            while (result[l - 1] < MAX_HIGH) {
                val d1 = result[i] % 10 - 1
                val d2 = result[i] % 10 + 1
                if (d1 >= 0) {
                    result[l++] = result[i] * 10 + d1
                }
                if (d2 <= 9) {
                    result[l++] = result[i] * 10 + d2
                }
                ++i
            }
            result[result.size - 1] = Int.MAX_VALUE
            result
        }
    }
}

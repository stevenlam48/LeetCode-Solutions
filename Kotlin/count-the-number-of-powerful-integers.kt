package countthenumberofpowerfulintegers
// Time:  O(logf)
// Space: O(1)

class Solution {
    fun numberOfPowerfulInt(start: Long, finish: Long, limit: Int, s: String): Long {
        fun power(base: Long, exponent: Int): Long {
            var result = 1L
            repeat(exponent) {
                result *= base
            }
            return result
        }
        fun length(value: Long): Int {
            var x = value
            var result = 0
            while (x != 0L) {
                ++result
                x /= 10
            }
            return result
        }
        fun count(x: Long): Long {
            var result = 0L
            val n = length(x)
            val l = n - s.length
            var base = power(10L, n)
            var i = 0
            var cnt = if (l >= 0) power((limit + 1).toLong(), l) else 0L
            while (i < l) {
                base /= 10
                val curr = (x / base % 10).toInt()
                cnt /= limit + 1
                result += (minOf(curr - 1, limit) + 1) * cnt
                if (curr > limit) {
                    break
                }
                ++i
            }
            if (i == l) {
                if (x % base >= s.toLong()) {
                    ++result
                }
            }
            return result
        }
        return count(finish) - count(start - 1)
    }
}

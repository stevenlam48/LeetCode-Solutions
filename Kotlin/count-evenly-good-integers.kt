package countevenlygoodintegers

// Time:  O(logr)
// Space: O(1)

// math
class Solution {
    fun countEvenlyGoodIntegers(l: Long, r: Long): Long {
        fun count(n0: Long): Long {
            var n = n0
            if (n <= 0) {
                return 0
            }
            var parity = 0
            var q = n / 10
            while (q != 0L) {
                if ((q % 10) % 2 == 0L) {
                    parity = parity xor 1
                }
                q /= 10
            }
            val qq = n / 10
            val rr = n % 10
            return if (parity != 0) qq * 5 + rr / 2 + 1 else qq * 5 + (rr + 1) / 2
        }

        return count(r) - count(l - 1)
    }
}

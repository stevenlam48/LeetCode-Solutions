package countgoodintegersinarange

// Time:  O(10 * logr)
// Space: O(10)

class Solution {
    fun goodIntegers(l: Long, r: Long, k: Int): Long {
        fun toDigits(value: Long): IntArray {
            var x = value
            val digits = mutableListOf<Int>()
            while (x != 0L) {
                digits.add((x % 10).toInt())
                x /= 10
            }
            digits.reverse()
            if (digits.isEmpty()) {
                digits.add(0)
            }
            return digits.toIntArray()
        }

        fun count(n: Long): Long {
            if (n < 0) {
                return 0
            }
            val digits = toDigits(n)
            var result = 1L
            var bound = digits.size
            for (i in 1 until digits.size) {
                if (kotlin.math.abs(digits[i] - digits[i - 1]) > k) {
                    bound = i
                    break
                }
            }
            if (bound == digits.size) {
                ++result
            }
            val prefix = LongArray(11)
            for (i in digits.size - 1 downTo 0) {
                val dp = LongArray(10) { 1 }
                if (i != digits.size - 1) {
                    for (d in dp.indices) {
                        dp[d] = prefix[minOf(d + k, 9) + 1] - prefix[maxOf(d - k, 0)]
                    }
                }
                for (j in dp.indices) {
                    prefix[j + 1] = prefix[j] + dp[j]
                }
                result += prefix[(if (i == 0) digits[0] - 1 else 9) + 1] - prefix[1]
                if (i in 1..bound) {
                    result += maxOf(
                        prefix[minOf(digits[i - 1] + k, digits[i] - 1) + 1] -
                            prefix[maxOf(digits[i - 1] - k, 0)],
                        0L
                    )
                }
            }
            return result
        }

        return count(r) - count(l - 1)
    }
}

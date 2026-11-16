package findpalindromewithfixedlength

// Time:  O(n * l)
// Space: O(1)

import kotlin.math.pow

class Solution {
    fun kthPalindrome(queries: IntArray, intLength: Int): LongArray {
        val maxX = 10.0.pow((intLength + 1) / 2).toLong() - 1
        fun reverse(value: Long): Long {
            var x = value
            var result = 0L
            while (x != 0L) {
                result = result * 10 + x % 10
                x /= 10
            }
            return result
        }

        fun f(value: Long): Long {
            var x = value
            x = 10.0.pow((intLength - 1) / 2).toLong() + (x - 1)
            if (x > maxX) {
                return -1L
            }
            return x * 10.0.pow(intLength / 2).toLong() + reverse(if (intLength % 2 != 0) x / 10 else x)
        }

        return LongArray(queries.size) { i -> f(queries[i].toLong()) }
    }
}

package largestpalindromeproduct

import kotlin.math.pow
import kotlin.math.sqrt

// Time:  O(n * 10^n)
// Space: O(n)

class Solution {
    fun largestPalindrome(n: Int): Int {
        if (n == 1) {
            return 9
        }
        val upper = 10.0.pow(n).toInt() - 1
        for (k in 2..upper) {
            val left = 10.0.pow(n).toInt() - k
            val right = left.toString().reversed().toInt()
            val d = k.toLong() * k - right.toLong() * 4
            if (d < 0) {
                continue
            }
            val root = sqrt(d.toDouble()).toInt()
            if (sqrt(d.toDouble()) == root.toDouble() && k % 2 == root % 2) {
                return ((left.toLong() * 10.0.pow(n).toLong() + right) % 1337).toInt()
            }
        }
        return -1
    }
}

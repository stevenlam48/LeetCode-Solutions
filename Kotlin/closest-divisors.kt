package closestdivisors

import kotlin.math.sqrt

// Time:  O(sqrt(n))
// Space: O(1)
class Solution {
    fun closestDivisors(num: Int): IntArray {
        val first = divisors(num + 1)
        val second = divisors(num + 2)
        return if (first[1] - first[0] <= second[1] - second[0]) first else second
    }

    private fun divisors(n: Int): IntArray {
        for (d in sqrt(n.toDouble()).toInt() downTo 1) {
            if (n % d == 0) {
                return intArrayOf(d, n / d)
            }
        }
        return intArrayOf(1, n)
    }
}

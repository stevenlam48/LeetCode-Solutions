package determinetheminimumsumofakavoidingarray

import kotlin.math.min

// Time:  O(1)
// Space: O(1)

class Solution {
    fun minimumSum(n: Int, k: Int): Int {
        fun arithmeticProgressionSum(a: Int, d: Int, count: Int): Int =
            (a + (a + (count - 1) * d)) * count / 2

        val a = min(k / 2, n)
        val b = n - a
        return arithmeticProgressionSum(1, 1, a) + arithmeticProgressionSum(k, 1, b)
    }
}

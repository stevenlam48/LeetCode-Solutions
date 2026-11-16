package sumofsquarenumbers

// Time:  O(sqrt(c) * logc)
// Space: O(1)

import kotlin.math.sqrt

class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0L
        while (a * a <= c) {
            val b = sqrt((c - a * a).toDouble()).toInt()
            if (a * a + b.toLong() * b == c.toLong()) {
                return true
            }
            ++a
        }
        return false
    }
}
